package view;

import constants.SwingConstants;
import controller.RegisterController;

import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame {

    private RegisterController controller;
    private JLabel emailLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel passwordLabel;
    private JTextField email;
    private JTextField firstName;
    private JTextField lastName;
    private JPasswordField password;
    private JCheckBox showPassword;
    private JButton register;
    private JButton loginBtn;
    private JButton resetBtn;
    private ImageIcon image;
    private JLabel imageLabel;
    private JLabel registerLabel;
    private JLabel alreadyHaveAnAccount;
    private JPanel mainPanel;

    public RegisterView(){

        init();

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        registerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        imagePanel.setBackground(Color.MAGENTA);
        imagePanel.add(imageLabel);
        imagePanel.add(registerLabel);

        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.X_AXIS));
        emailPanel.setBackground(Color.MAGENTA);
        emailPanel.add(emailLabel);
        emailPanel.add(Box.createRigidArea(new Dimension(35, 0)));
        emailPanel.add(email);

        JPanel firstNamePanel = new JPanel();
        firstNamePanel.setLayout(new BoxLayout(firstNamePanel, BoxLayout.X_AXIS));
        firstNamePanel.setBackground(Color.MAGENTA);
        firstNamePanel.add(firstNameLabel);
        firstNamePanel.add(firstName);

        JPanel lastNamePanel = new JPanel();
        lastNamePanel.setLayout(new BoxLayout(lastNamePanel, BoxLayout.X_AXIS));
        lastNamePanel.setBackground(Color.MAGENTA);
        lastNamePanel.add(lastNameLabel);
        lastNamePanel.add(lastName);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
        passwordPanel.setBackground(Color.MAGENTA);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(password);

        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.X_AXIS));
        registerPanel.setBackground(Color.MAGENTA);
        registerPanel.add(showPassword);
        registerPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        registerPanel.add(register);
        registerPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        registerPanel.add(resetBtn);

        JPanel credentialsPanel = new JPanel();
        credentialsPanel.setLayout(new BoxLayout(credentialsPanel, BoxLayout.Y_AXIS));
        credentialsPanel.setBackground(Color.MAGENTA);
        credentialsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        credentialsPanel.add(emailPanel);
        credentialsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        credentialsPanel.add(firstNamePanel);
        credentialsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        credentialsPanel.add(lastNamePanel);
        credentialsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        credentialsPanel.add(passwordPanel);
        credentialsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        credentialsPanel.add(registerPanel);

        JPanel backPanel = new JPanel();
        backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.Y_AXIS));
        backPanel.setBackground(Color.MAGENTA);
        alreadyHaveAnAccount.setAlignmentX(Component.CENTER_ALIGNMENT);
        alreadyHaveAnAccount.setAlignmentY(Component.CENTER_ALIGNMENT);
        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginBtn.setAlignmentY(Component.CENTER_ALIGNMENT);
        backPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        backPanel.add(alreadyHaveAnAccount);
        backPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        backPanel.add(loginBtn);
        backPanel.add(Box.createRigidArea(new Dimension(0, 50)));

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
        mainPanel.add(backPanel, BorderLayout.SOUTH);

        this.setContentPane(mainPanel);

        register.addActionListener(e -> { eliminateView(); controller.registerUser(email.getText(), firstName.getText(), lastName.getText(), new String(password.getPassword())); });
        loginBtn.addActionListener(e -> { eliminateView(); controller.goBack(); });
        showPassword.addActionListener(e -> showPassword());
        resetBtn.addActionListener(e -> resetParameters());

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
        firstName.setText("");
        lastName.setText("");

    }

    private void init(){

        controller = new RegisterController();

        emailLabel = new JLabel("Email: ");
        email = new JTextField();
        email.setMaximumSize(new Dimension(300, 80));

        firstNameLabel = new JLabel("First Name: ");
        firstName = new JTextField();
        firstName.setMaximumSize(new Dimension(300, 80));

        lastNameLabel = new JLabel("Last Name: ");
        lastName = new JTextField();
        lastName.setMaximumSize(new Dimension(300, 80));

        passwordLabel = new JLabel("Password: ");
        password = new JPasswordField();
        password.setMaximumSize(new Dimension(300, 80));

        showPassword = new JCheckBox("Show Password");
        showPassword.setBackground(Color.MAGENTA);
        loginBtn = new JButton("Back");
        resetBtn = new JButton("RESET");
        register = new JButton("Register");

        image = new ImageIcon("D:\\An3_sem2\\PS(PROGRAMARE SOFTWARE)\\LAB\\ps-2022-30235-a1-Alexandra-Pop-master\\src\\main\\resources\\uiImages\\registerImage.png");
        imageLabel = new JLabel(image);
        registerLabel = new JLabel("USER REGISTRATION:");
        alreadyHaveAnAccount = new JLabel("Already have an account?");

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        setTitle("Register");
        setSize(new Dimension(constants.SwingConstants.WINDOW_WIDTH, SwingConstants.WINDOW_HEIGHT));
        setVisible(true);
        setResizable(false);
        setLocation(new Point(200, 0));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
