package controller;

import constants.ErrorMessages;
import constants.SuccessMessages;
import service.UserService;
import view.LoginView;
import javax.swing.*;

public class RegisterController {

    private UserService userRegisterService;

    public RegisterController(){
        userRegisterService = new UserService();
    }

    public void registerUser(String email, String firstName, String lastName, String password){
        if(userRegisterService.doRegisterUser(email, firstName, lastName, password)){
            JOptionPane.showMessageDialog(null, SuccessMessages.SUCCESSFUL_REGISTRATION,
                    "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, ErrorMessages.REGISTER_ERROR,
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        new LoginView();
    }

    public void goBack(){
        new LoginView();
    }

}
