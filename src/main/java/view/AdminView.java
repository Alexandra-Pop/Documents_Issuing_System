package view;

import constants.SwingConstants;
import controller.AdminController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AdminView extends JFrame {
    private AdminController controller;
    private ImageIcon image;
    private JLabel imageLabel;
    private JLabel adminLabel;
    private JButton viewUsers;
    private JButton viewDocuments;
    private JButton viewRequests;
    private JButton acceptRequest;
    private JButton declineRequest;
    private JButton logout;
    private JLabel logoutLabel;
    private JTable tableUsers;
    private JTable tableRequests;
    private JTable tableDocuments;
    private JButton deleteDocument;
    private JLabel typeLabel;
    private JLabel descriptionLabel;
    private JTextField type;
    private JTextField description;
    private JButton addDocument;
    private JScrollPane scrollUsers;
    private JScrollPane scrollDocuments;
    private JScrollPane scrollRequests;
    private JPanel mainPanel;

    public AdminView(){

        init();

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        adminLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        adminLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        imagePanel.setBackground(Color.MAGENTA);
        imagePanel.add(imageLabel);
        imagePanel.add(adminLabel);

        JPanel documentsTypePanel = new JPanel();
        documentsTypePanel.setLayout(new BoxLayout(documentsTypePanel, BoxLayout.X_AXIS));
        documentsTypePanel.setBackground(Color.MAGENTA);
        documentsTypePanel.add(typeLabel);
        documentsTypePanel.add(Box.createRigidArea(new Dimension(55, 0)));
        documentsTypePanel.add(type);

        JPanel documentsDescriptionPanel = new JPanel();
        documentsDescriptionPanel.setLayout(new BoxLayout(documentsDescriptionPanel, BoxLayout.X_AXIS));
        documentsDescriptionPanel.setBackground(Color.MAGENTA);
        documentsDescriptionPanel.add(descriptionLabel);
        documentsDescriptionPanel.add(description);

        JPanel addDocumentsPanel = new JPanel();
        addDocumentsPanel.setLayout(new BoxLayout(addDocumentsPanel, BoxLayout.Y_AXIS));
        addDocumentsPanel.setBackground(Color.MAGENTA);
        addDocumentsPanel.add(documentsTypePanel);
        addDocumentsPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        addDocumentsPanel.add(documentsDescriptionPanel);
        addDocumentsPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        addDocument.setAlignmentX(Component.CENTER_ALIGNMENT);
        addDocument.setAlignmentY(Component.CENTER_ALIGNMENT);
        addDocumentsPanel.add(addDocument);

        JPanel deleteDocumentsPanel = new JPanel();
        deleteDocumentsPanel.setLayout(new BoxLayout(deleteDocumentsPanel, BoxLayout.Y_AXIS));
        deleteDocumentsPanel.setBackground(Color.MAGENTA);
        deleteDocumentsPanel.add(scrollDocuments);
        scrollDocuments.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollDocuments.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        deleteDocumentsPanel.add(Box.createRigidArea(new Dimension(50, 0)));

        JPanel deleteDocumentsButtonsPanel = new JPanel();
        deleteDocumentsButtonsPanel.setLayout(new BoxLayout(deleteDocumentsButtonsPanel, BoxLayout.X_AXIS));
        deleteDocumentsButtonsPanel.setBackground(Color.MAGENTA);
        deleteDocument.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteDocument.setAlignmentY(Component.CENTER_ALIGNMENT);
        viewDocuments.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewDocuments.setAlignmentY(Component.CENTER_ALIGNMENT);
        deleteDocumentsButtonsPanel.add(viewDocuments);
        deleteDocumentsButtonsPanel.add(deleteDocument);

        deleteDocumentsPanel.add(deleteDocumentsButtonsPanel);

        JPanel documentsPanel = new JPanel();
        documentsPanel.setLayout(new BoxLayout(documentsPanel, BoxLayout.Y_AXIS));
        documentsPanel.setBackground(Color.MAGENTA);
        documentsPanel.setPreferredSize(new Dimension(SwingConstants.WINDOW_WIDTH/3, SwingConstants.WINDOW_HEIGHT));
        documentsPanel.add(addDocumentsPanel);
        documentsPanel.add(deleteDocumentsPanel);

        JPanel usersPanel = new JPanel();
        usersPanel.setLayout(new BoxLayout(usersPanel, BoxLayout.Y_AXIS));
        usersPanel.setBackground(Color.MAGENTA);
        usersPanel.setPreferredSize(new Dimension(SwingConstants.WINDOW_WIDTH / 3, SwingConstants.WINDOW_HEIGHT));
        usersPanel.add(scrollUsers);
        scrollUsers.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollUsers.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        viewUsers.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewUsers.setAlignmentY(Component.CENTER_ALIGNMENT);
        usersPanel.add(viewUsers);

        JPanel requestsButtonsPanel = new JPanel();
        requestsButtonsPanel.setLayout(new BoxLayout(requestsButtonsPanel, BoxLayout.X_AXIS));
        requestsButtonsPanel.setBackground(Color.MAGENTA);
        acceptRequest.setAlignmentX(Component.CENTER_ALIGNMENT);
        acceptRequest.setAlignmentY(Component.CENTER_ALIGNMENT);
        declineRequest.setAlignmentX(Component.CENTER_ALIGNMENT);
        declineRequest.setAlignmentY(Component.CENTER_ALIGNMENT);
        viewRequests.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewRequests.setAlignmentY(Component.CENTER_ALIGNMENT);
        requestsButtonsPanel.add(viewRequests);
        requestsButtonsPanel.add(acceptRequest);
        requestsButtonsPanel.add(declineRequest);

        JPanel requestsPanel = new JPanel();
        requestsPanel.setLayout(new BoxLayout(requestsPanel, BoxLayout.Y_AXIS));
        requestsPanel.setBackground(Color.MAGENTA);
        requestsPanel.setPreferredSize(new Dimension(SwingConstants.WINDOW_WIDTH/3, SwingConstants.WINDOW_HEIGHT));
        requestsPanel.add(scrollRequests);
        scrollRequests.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollRequests.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        requestsPanel.add(requestsButtonsPanel);

        JPanel logOutPanel = new JPanel();
        logOutPanel.setLayout(new BoxLayout(logOutPanel, BoxLayout.Y_AXIS));
        logOutPanel.setBackground(Color.MAGENTA);
        logoutLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        logout.setAlignmentX(Component.CENTER_ALIGNMENT);
        logout.setAlignmentY(Component.CENTER_ALIGNMENT);
        logOutPanel.add(logoutLabel);
        logOutPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        logOutPanel.add(logout);
        logOutPanel.add(Box.createRigidArea(new Dimension(0, 50)));

        mainPanel.add(imagePanel, BorderLayout.NORTH);
        mainPanel.add(documentsPanel, BorderLayout.WEST);
        mainPanel.add(requestsPanel, BorderLayout.EAST);
        mainPanel.add(usersPanel, BorderLayout.CENTER);
        mainPanel.add(logOutPanel, BorderLayout.SOUTH);
        this.setContentPane(mainPanel);

        viewUsers.addActionListener(e -> { List<Object[]> users = controller.doGetAllRegularUsers(); createTable(users, tableUsers, new String[]{"EMAIL", "FIRST NAME", "LAST NAME"}); });
        logout.addActionListener(e -> { eliminateView(); controller.doLogout(); });
        addDocument.addActionListener(e -> controller.addDocument(type.getText(), description.getText()));
        viewDocuments.addActionListener(e -> { List<Object[]> documents = controller.doGetAllDocuments(); createTable(documents, tableDocuments, new String[]{"TYPE", "DESCRIPTION"}); });
        viewRequests.addActionListener(e -> { List<Object[]> requests = controller.doGetAllRequests(); createTable(requests, tableRequests, new String[]{"EMAIL", "FIRST NAME", "LAST NAME", "STREET", "NUMBER", "TYPE", "DESCRIPTION", "STATUS", "DATE" }); });
        deleteDocument.addActionListener(e -> { String type = getSelectedItemsFromTable(tableDocuments, 0); String description = getSelectedItemsFromTable(tableDocuments, 1); controller.deleteDocument(type, description); });
        acceptRequest.addActionListener(e -> { String email = getSelectedItemsFromTable(tableRequests, 0); String street = getSelectedItemsFromTable(tableRequests, 3); String number = getSelectedItemsFromTable(tableRequests, 4); String type = getSelectedItemsFromTable(tableRequests, 5); String description = getSelectedItemsFromTable(tableRequests, 6); String date = getSelectedItemsFromTable(tableRequests, 8); controller.acceptRequest(email, street, number, type, description, date); });
        declineRequest.addActionListener(e -> { String email = getSelectedItemsFromTable(tableRequests, 0); String street = getSelectedItemsFromTable(tableRequests, 3); String number = getSelectedItemsFromTable(tableRequests, 4); String type = getSelectedItemsFromTable(tableRequests, 5); String description = getSelectedItemsFromTable(tableRequests, 6); String date = getSelectedItemsFromTable(tableRequests, 8); controller.declineRequest(email, street, number, type, description, date); });


    }

    public void eliminateView(){
        dispose();
    }

    private String getSelectedItemsFromTable(JTable table, int column){
        int row = table.getSelectedRow();
        String result = "";
        if(row != -1) {
            result = table.getValueAt(row, column).toString();
        }
        return result;
    }

    public Vector createDataVector(List<Object[]> users){
        Vector data = new Vector();
        for(Object[] user: users){
            Vector userInfo = new Vector();
            for(Object info: user){
                userInfo.add(info);
            }
            data.add(userInfo);
        }

        return data;
    }

    public void createTable(List<Object[]> objects, JTable table, String[] columnsStrings){
        Vector columns = new Vector();
        for(String info: columnsStrings){
            columns.add(info);
        }
        DefaultTableModel model = new DefaultTableModel(createDataVector(objects), columns);
        table.setModel(model);
        revalidate();
        repaint();
    }

    private void init(){

        controller = new AdminController();

        image = new ImageIcon("D:\\An3_sem2\\PS(PROGRAMARE SOFTWARE)\\LAB\\ps-2022-30235-a1-Alexandra-Pop-master\\src\\main\\resources\\uiImages\\adminImage.png");
        imageLabel = new JLabel(image);

        adminLabel = new JLabel("FEREASTRA ADMIN:");
        viewUsers = new JButton("VIEW USERS");
        acceptRequest = new JButton("ACCEPT");
        declineRequest = new JButton("DECLINE");
        logoutLabel = new JLabel("Want to log out?");

        logout = new JButton("LOG OUT");
        deleteDocument = new JButton("DELETE DOCUMENT");
        typeLabel = new JLabel("DOC. TYPE: ");
        descriptionLabel = new JLabel("DOC. DESCRIPTION: ");
        type = new JTextField();
        description = new JTextField();
        addDocument = new JButton("ADD DOCUMENT");
        viewDocuments = new JButton("VIEW DOCUMENTS");
        viewRequests = new JButton("VIEW REQUESTS");

        tableUsers = new JTable();
        tableDocuments = new JTable();
        tableRequests = new JTable();
        createTable(new ArrayList<Object[]>(), tableDocuments, new String[]{"TYPE", "DESCRIPTION"});
        createTable(new ArrayList<Object[]>(), tableUsers, new String[]{"EMAIL", "FIRST NAME", "LAST NAME"});
        createTable(new ArrayList<Object[]>(), tableRequests, new String[]{"EMAIL", "FIRST NAME", "LAST NAME", "STREET", "NUMBER", "TYPE", "DESCRIPTION", "STATUS", "DATE" });
        tableRequests.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        scrollUsers = new JScrollPane(tableUsers);
        scrollDocuments = new JScrollPane(tableDocuments);
        scrollRequests = new JScrollPane(tableRequests);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        setTitle("Admin");
        setSize(new Dimension(constants.SwingConstants.WINDOW_WIDTH, SwingConstants.WINDOW_HEIGHT));
        setVisible(true);
        setResizable(false);
        setLocation(new Point(200, 0));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
