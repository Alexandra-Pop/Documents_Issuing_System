package view;

import controller.LoginController;

import javax.swing.*;
import java.awt.*;

import constants.SwingConstants;

public class LoginView extends JFrame {

    private LoginController controller;
    private JTextField email;
    private JPasswordField password;
    private JCheckBox showPassword;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JButton resetBtn;
    private JButton loginBtn;
    private ImageIcon image;
    private JLabel imageLabel;
    private JLabel userLogin;
    private JLabel doNotHaveAnAccountLabel;
    private JButton signUpButton;
    private JPanel mainPanel;

    public LoginView(){

        init();

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        userLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        userLogin.setAlignmentY(Component.CENTER_ALIGNMENT);
        imagePanel.setBackground(Color.MAGENTA);
        imagePanel.add(imageLabel);
        imagePanel.add(userLogin);

        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.X_AXIS));
        emailPanel.setBackground(Color.MAGENTA);
        emailPanel.add(emailLabel);
        emailPanel.add(Box.createRigidArea(new Dimension(25, 0)));
        emailPanel.add(email);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
        passwordPanel.setBackground(Color.MAGENTA);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(password);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.X_AXIS));
        loginPanel.setBackground(Color.MAGENTA);
        loginPanel.add(showPassword);
        loginPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        loginPanel.add(loginBtn);
        loginPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        loginPanel.add(resetBtn);

        JPanel credentialsPanel = new JPanel();
        credentialsPanel.setLayout(new BoxLayout(credentialsPanel, BoxLayout.Y_AXIS));
        credentialsPanel.setBackground(Color.MAGENTA);
        credentialsPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        credentialsPanel.add(emailPanel);
        credentialsPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        credentialsPanel.add(passwordPanel);
        credentialsPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        credentialsPanel.add(loginPanel);

        JPanel registrationPanel = new JPanel();
        registrationPanel.setLayout(new BoxLayout(registrationPanel, BoxLayout.Y_AXIS));
        registrationPanel.setBackground(Color.MAGENTA);
        doNotHaveAnAccountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        doNotHaveAnAccountLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        signUpButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        registrationPanel.add(doNotHaveAnAccountLabel);
        registrationPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        registrationPanel.add(signUpButton);
        registrationPanel.add(Box.createRigidArea(new Dimension(0, 50)));

        JPanel pad1 = new JPanel();
        pad1.setPreferredSize(new Dimension(SwingConstants.WINDOW_WIDTH/4, SwingConstants.WINDOW_HEIGHT));
        pad1.setBackground(Color.MAGENTA);

        JPanel pad2 = new JPanel();
        pad2.setPreferredSize(new Dimension(SwingConstants.WINDOW_WIDTH/4, SwingConstants.WINDOW_HEIGHT));
        pad2.setBackground(Color.MAGENTA);

        mainPanel.add(imagePanel, BorderLayout.NORTH);
        mainPanel.add(pad1, BorderLayout.WEST);
        mainPanel.add(credentialsPanel, BorderLayout.CENTER);
        mainPanel.add(pad2, BorderLayout.EAST);
        mainPanel.add(registrationPanel, BorderLayout.SOUTH);

        this.setContentPane(mainPanel);

        loginBtn.addActionListener(e -> { if(controller.doLogin(email.getText(), new String(password.getPassword()))) {eliminateView();} });
        signUpButton.addActionListener(e -> {eliminateView(); controller.doRegister();});
        resetBtn.addActionListener(e -> resetParameters());
        showPassword.addActionListener(e -> showPassword());

    }

    public void eliminateView(){
        dispose();
    }

    public void showPassword(){
        if(showPassword.isSelected()){
            password.setEchoChar((char)0);
        }
        else{
            password.setEchoChar('*');
        }

    }

    public void resetParameters(){

        email.setText("");
        password.setText("");

    }

    private void init(){

        controller = new LoginController();

        email = new JTextField();
        email.setMaximumSize(new Dimension(300, 50));
        password = new JPasswordField();
        password.setMaximumSize(new Dimension(300, 50));

        emailLabel = new JLabel("Email: ");
        passwordLabel = new JLabel("Password: ");

        loginBtn = new JButton("Log in");
        resetBtn = new JButton("Reset");
        showPassword = new JCheckBox("Show Password");
        showPassword.setBackground(Color.MAGENTA);

        image = new ImageIcon("D:\\An3_sem2\\PS(PROGRAMARE SOFTWARE)\\LAB\\ps-2022-30235-a1-Alexandra-Pop-master\\src\\main\\resources\\uiImages\\loginImage.png");
        imageLabel = new JLabel(image);

        userLogin = new JLabel("USER LOGIN:");
        signUpButton = new JButton("Sign up");
        doNotHaveAnAccountLabel = new JLabel("Don't have an account?");

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        setTitle("LogIn");
        setSize(new Dimension(SwingConstants.WINDOW_WIDTH, SwingConstants.WINDOW_HEIGHT));
        setVisible(true);
        setResizable(false);
        setLocation(new Point(200, 0));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
