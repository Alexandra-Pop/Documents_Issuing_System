package controller;

import constants.ErrorMessages;
import service.UserService;
import view.AdminView;
import view.RegisterView;
import view.RegularUserView;

import javax.swing.*;

public class LoginController {

    private UserService userService = new UserService();

    public boolean doLogin(String email, String password){
        String userId = userService.doLogin(email, password);
        if(userId == null){
            JOptionPane.showMessageDialog(null, ErrorMessages.LOGIN_ERROR,
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            if(userService.isUserAnAdmin(userId)) {
                new AdminView();
            }
            else{
                new RegularUserView(userId);
            }
            return true;
        }
    }

    public void doRegister(){
        new RegisterView();
    }

}
