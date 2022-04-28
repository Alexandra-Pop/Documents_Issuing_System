package controller;

import constants.ErrorMessages;
import constants.SuccessMessages;
import org.apache.commons.lang3.StringUtils;
import service.UserService;
import view.LoginView;
import javax.swing.*;
import java.util.List;

public class RegularUserController {

    private UserService userService;
    private String userId;

    public RegularUserController(String userId){
        userService = new UserService();
        this.userId = userId;
    }

    public void doLogout(){
        new LoginView();
    }

    public List<Object[]> doViewDocuments(){
        return userService.doGetAllDocuments();
    }

    public void addResidence(String street, String number){
        int addressNumber;
        if(StringUtils.isNotEmpty(street) && StringUtils.isNotEmpty(number)){
            try{
                addressNumber = Integer.parseInt(number);
                if(userService.addResidence(userId, street, addressNumber)){
                    JOptionPane.showMessageDialog(null, SuccessMessages.SUCCESSFUL_RESIDENCE_ADDING,
                            "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, ErrorMessages.ADD_RESIDENCE_ERROR,
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, ErrorMessages.FORMAT_ERROR,
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, ErrorMessages.EMPTY_STRINGS_ERROR,
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteResidence(String street, String number){
        int addressNumber;
        try{
            addressNumber = Integer.parseInt(number);
            if(userService.deleteResidence(userId, street, addressNumber)){
                JOptionPane.showMessageDialog(null, SuccessMessages.SUCCESSFUL_RESIDENCE_DELETING,
                        "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, ErrorMessages.DELETE_RESIDENCE_ERROR,
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ErrorMessages.FORMAT_ERROR,
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public List<Object[]> getAllResidences(){
        return userService.getAllResidences(userId);
    }

    public List<Object[]> getAllRequests(){
        return userService.getAllRequests(userId);
    }

    public void addRequest(String street, String number, String type, String description){
        int addressNumber;
        try {
            addressNumber = Integer.parseInt(number);
            if(userService.addRequest(userId, street, addressNumber, type, description)){
                JOptionPane.showMessageDialog(null, SuccessMessages.SUCCESSFUL_REQUEST_ADDING,
                        "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, ErrorMessages.ADD_REQUEST_ERROR,
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ErrorMessages.FORMAT_ERROR,
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteRequest(String email, String street, String number, String type, String description, String date){
        int addressNumber;
        try{
            addressNumber = Integer.parseInt(number);
            if(userService.declineRequest(email, street, addressNumber, type, description, date) == 1){
                JOptionPane.showMessageDialog(null, SuccessMessages.SUCCESSFUL_REQUEST_DELETING,
                        "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, ErrorMessages.DELETE_REQUEST_ERROR,
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ErrorMessages.FORMAT_ERROR,
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateRequest(String email, String street, String number, String type, String description, String date){
        int addressNumber;
        try{
            addressNumber = Integer.parseInt(number);
            if(userService.updateRequest(email, street, addressNumber, type, description, date) == 1){
                JOptionPane.showMessageDialog(null, SuccessMessages.SUCCESSFUL_REQUEST_UPDATING,
                        "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, ErrorMessages.UPDATE_REQUEST_ERROR,
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ErrorMessages.FORMAT_ERROR,
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

}
