package service;

import entity.Document;
import entity.Residence;
import entity.User;
import entity.UserResidence;
import repository.*;
import validators.EmailValidator;
import java.time.LocalDate;
import java.util.List;

public class UserService {

    private UserRepo userRepo;
    private UserRoleRepo userRoleRepo;
    private DocumentRepo documentRepo;
    private ResidenceRepo residenceRepo;
    private UserResidenceRepo userResidenceRepo;
    private UserResidenceDocumentRepo userResidenceDocumentRepo;
    private EmailValidator emailValidator;

    public UserService(){
        userRepo = new UserRepo();
        userRoleRepo = new UserRoleRepo();
        documentRepo = new DocumentRepo();
        residenceRepo = new ResidenceRepo();
        userResidenceRepo = new UserResidenceRepo();
        userResidenceDocumentRepo = new UserResidenceDocumentRepo();
        emailValidator = new EmailValidator();
    }

    //LOGIN PENTRU ORICE TIP DE USER: RETURNEAZA ID-UL USER-ULUI CE SE LOGHEAZA SAU NULL.
    public String doLogin(String email, String password){
        return userRepo.findUserByEmailAndPassword(email, password);
    }

    //REGISTER PENTRU REGULAR USERS:
    public boolean doRegisterUser(String email, String firstName, String lastName, String password){
        boolean isEmailValid = emailValidator.validateEmail(email);
        if(isEmailValid){
            if(userRepo.findUserByEmail(email) != null){
                return false;
            }
            else{
                userRepo.insertNewUser(new User(email, firstName, lastName, password), userRoleRepo.findRoleByName("REGULAR"));
                return (userRepo.findUserByEmail(email) != null);
            }
        }
        return false;
    }

    //VERIFY IF USER IS ADMIN(USED WHEN LOGGING IN TO SEE WHAT VIEW TO DISPLAY -> ADMIN_VIEW OR REGULAR_USER_VIEW):
    public boolean isUserAnAdmin(String id){
        String roleName;
        try{
            roleName = userRepo.findUserById(id).getUserRole().getRoleName();
            return roleName.equals("ADMIN");
        }
        catch (NullPointerException ex){
            return false;
        }
    }

    //ACTION PERFORMED BY THE ADMIN TO SEE ALL THE USERS REGISTERED:
    public List<Object[]> doGetAllRegularUsers(){
        return userRepo.getAllUsersByRole(userRoleRepo.findRoleByName("REGULAR"));
    }

    //ACTION PERFORMED BY THE ADMIN TO ADD A NEW TYPE OF DOCUMENT:
    public boolean addDocument(String type, String description){
        if(documentRepo.findDocument(type, description) != null){
            return false;
        }
        else{
            documentRepo.insertNewDocument(new Document(type, description));
            if(documentRepo.findDocument(type, description) == null){
                return false;
            }
        }
        return true;
    }

    //ACTION PERFORMED BY THE ADMIN AND REGULAR USERS TO SEE ALL THE DOCUMENTS:
    public List<Object[]> doGetAllDocuments(){
        return documentRepo.getAllDocuments();
    }

    //ACTION PERFORMED BY THE ADMIN TO DELETE A DOCUMENT:
    public int deleteDocument(String type, String description){
        return documentRepo.deleteDocument(new Document(type, description));
    }

    //ACTION PERFORMED BY THE REGULAR USER TO SEE ALL HIS RESIDENCES:
    public List<Object[]> getAllResidences(String userId){
        return userResidenceRepo.getAllResidencesByUserId(userId);
    }

    //ACTION PERFORMED BY THE REGULAR USER TO ADD A RESIDENCE:
    public boolean addResidence(String userId, String street, int number){
        if(residenceRepo.findResidence(street, number) == null){
            residenceRepo.addResidence(new Residence(street, number));
        }

        if(userResidenceRepo.findUserResidenceByResidenceAndUserId(userId, residenceRepo.findResidence(street, number).getId()) == null){
            userResidenceRepo.insertNewUserResidence(userRepo.findUserById(userId), residenceRepo.findResidence(street, number));
        }
        else{
            return false;
        }
        return true;
    }

    //ACTION PERFORMED BY THE REGULAR USER TO DELETE A RESIDENCE:
    public boolean deleteResidence(String userId, String street, int number){
        String residenceId = residenceRepo.findResidence(street, number).getId();
        if(userResidenceRepo.getAllUsersByResidenceId(residenceId).size() == 1){
            userResidenceRepo.deleteUserResidenceById(userId, residenceId);
            residenceRepo.deleteResidence(residenceId);
        }
        else{
            userResidenceRepo.deleteUserResidenceById(userId, residenceId);
        }
        return true;
    }

    //ACTION PERFORMED BY THE REGULAR USER TO ADD A REQUEST(HE HAS TO CHOOSE A RESIDENCE AND A DOCUMENT FROM THE TABLE
    // AND PRESS ADD REQUEST):
    public boolean addRequest(String userId, String street, int number, String type, String description){
        Document document = documentRepo.findDocument(type, description);
        Residence residence = residenceRepo.findResidence(street, number);
        UserResidence userResidence = null;
        String residenceId = "";
        int nbOfRequests = 0;
        String date = LocalDate.now().toString();
        if(document != null && residence != null){
            residenceId = residence.getId();
            userResidence = userResidenceRepo.findUserResidenceByResidenceAndUserId(userId, residenceId);
            nbOfRequests = userResidenceDocumentRepo.getNbOfUsersRequestsInAYear(userId, userResidence, document, date);
            if(userResidence != null && (userResidenceDocumentRepo.findRequestsByDate(userResidence, document, date) == null) && nbOfRequests < 3){
                userResidenceDocumentRepo.insertNewUserResidenceDocument(userResidence, document);
            }
            else{
                return false;
            }
            if(userResidence != null && (userResidenceDocumentRepo.getNbOfUsersRequestsInAYear(userId, userResidence, document, date) == (nbOfRequests + 1))){
                return true;
            }
        }
        return false;
    }

    //ACTION PERFORMED BY THE REGULAR USER TO SEE ALL HIS REQUESTS:
    public List<Object[]> getAllRequests(String userId){
        return userResidenceDocumentRepo.getUsersRequests(userId);
    }

    //ACTION PERFORMED BY THE ADMIN TO SEE ALL USER REQUESTS:
    public List<Object[]> getRequestsFromAllUsers(){
        return userResidenceDocumentRepo.getAllRequests();
    }

    //ACTION PERFORMED BY THE ADMIN TO ACCEPT A REQUEST:
    public int acceptRequest(String email, String street, int number, String type, String description, String date){
        Document document = documentRepo.findDocument(type, description);
        User user = userRepo.findUserByEmail(email);
        Residence residence = residenceRepo.findResidence(street, number);
        UserResidence userResidence = null;
        int updatedCount = 0;
        if(user != null && residence != null && document != null){
            userResidence = userResidenceRepo.findUserResidenceByResidenceAndUserId(user.getId(), residence.getId());
            updatedCount = userResidenceDocumentRepo.acceptRequest(userResidence, document, date);
        }
        return updatedCount;
    }

    //ACTION PERFORMED BY THE ADMIN TO DECLINE A REQUEST:
    public int declineRequest(String email, String street, int number, String type, String description, String date){
        Document document = documentRepo.findDocument(type, description);
        User user = userRepo.findUserByEmail(email);
        Residence residence = residenceRepo.findResidence(street, number);
        UserResidence userResidence = null;
        int deletedCount = 0;
        if(user != null && residence != null && document != null){
            userResidence = userResidenceRepo.findUserResidenceByResidenceAndUserId(user.getId(), residence.getId());
            deletedCount = userResidenceDocumentRepo.declineRequest(userResidence, document, date);
        }
        return deletedCount;
    }

    //ACTION PERFORMED BY THE REGULAR USER TO UPDATE A REQUEST(IT UPDATES THE DATE BECAUSE THERE ARE NO OTHER IMPORTANT ATTRIBUTES)::
    public int updateRequest(String email, String street, int number, String type, String description, String date){
        Document document = documentRepo.findDocument(type, description);
        User user = userRepo.findUserByEmail(email);
        Residence residence = residenceRepo.findResidence(street, number);
        UserResidence userResidence = null;
        int updatedCount = 0;
        if(user != null && residence != null && document != null){
            userResidence = userResidenceRepo.findUserResidenceByResidenceAndUserId(user.getId(), residence.getId());
            if(userResidenceDocumentRepo.findRequestsByDate(userResidence, document, LocalDate.now().toString()) == null){
                updatedCount = userResidenceDocumentRepo.updateRequest(userResidence, document, date);
            }
        }
        return updatedCount;
    }

}
