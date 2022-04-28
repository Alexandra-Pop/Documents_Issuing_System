package controller;

import constants.ErrorMessages;
import constants.SuccessMessages;
import org.apache.commons.lang3.StringUtils;
import service.UserService;
import view.LoginView;
import javax.swing.*;
import java.util.List;

public class AdminController {

    private UserService userService;

    public AdminController(){

        userService = new UserService();

    }

    public List<Object[]> doGetAllRegularUsers(){
        return userService.doGetAllRegularUsers();
    }

    public List<Object[]> doGetAllDocuments(){
        return userService.doGetAllDocuments();
    }

    public List<Object[]> doGetAllRequests(){
        return userService.getRequestsFromAllUsers();
    }

    public void addDocument(String type, String description){
        if(StringUtils.isNotEmpty(type) && StringUtils.isNotEmpty(description)){
            if(!userService.addDocument(type, description)){
                JOptionPane.showMessageDialog(null, ErrorMessages.ADD_DOCUMENT_ERROR,
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, SuccessMessages.SUCCESSFUL_DOCUMENT_ADDING,
                    "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, ErrorMessages.EMPTY_STRINGS_ERROR,
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteDocument(String type, String description){
        if(userService.deleteDocument(type, description) == 0){
            JOptionPane.showMessageDialog(null, ErrorMessages.DELETE_DOCUMENT_ERROR,
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, SuccessMessages.SUCCESSFUL_DOCUMENT_DELETING,
                    "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void acceptRequest(String email, String street, String number, String type, String description, String date){
        int addressNumber;
        try{
            addressNumber = Integer.parseInt(number);
            if(userService.acceptRequest(email, street, addressNumber, type, description, date) == 1){
                JOptionPane.showMessageDialog(null, SuccessMessages.SUCCESSFUL_REQUEST_ACCEPTING,
                        "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, ErrorMessages.ACCEPT_REQUEST_ERROR,
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ErrorMessages.FORMAT_ERROR,
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void declineRequest(String email, String street, String number, String type, String description, String date){
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

    public void doLogout(){
        new LoginView();
    }

}
