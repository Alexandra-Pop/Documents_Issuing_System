package view;

import constants.SwingConstants;
import controller.RegularUserController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RegularUserView extends JFrame {

    private RegularUserController controller;
    private ImageIcon image;
    private JLabel imageLabel;
    private JLabel regularUserLabel;
    private JButton viewResidences;
    private JButton viewRequests;
    private JButton viewDocuments;
    private JButton addRequest;
    private JButton deleteRequest;
    private JButton updateRequest;
    private JButton addResidence;
    private JButton deleteResidence;
    private JButton logout;
    private JLabel logoutLabel;
    private JTable tableResidences;
    private JTable tableRequests;
    private JTable tableDocuments;
    private JLabel streetLabel;
    private JLabel numberLabel;
    private JTextField street;
    private JTextField number;
    private JScrollPane scrollResidences;
    private JScrollPane scrollRequests;
    private JScrollPane scrollDocuments;
    private JPanel mainPanel;

    public RegularUserView(String userId){

        init(userId);

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        regularUserLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        regularUserLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        imagePanel.setBackground(Color.MAGENTA);
        imagePanel.add(imageLabel);
        imagePanel.add(regularUserLabel);
        imagePanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel streetPanel = new JPanel();
        streetPanel.setLayout(new BoxLayout(streetPanel, BoxLayout.X_AXIS));
        streetPanel.setBackground(Color.MAGENTA);
        streetPanel.add(streetLabel);
        streetPanel.add(street);

        JPanel numberPanel = new JPanel();
        numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.X_AXIS));
        numberPanel.setBackground(Color.MAGENTA);
        numberPanel.add(numberLabel);
        numberPanel.add(number);

        JPanel residencesButtonsPanel = new JPanel();
        residencesButtonsPanel.setLayout(new BoxLayout(residencesButtonsPanel, BoxLayout.X_AXIS));
        residencesButtonsPanel.setBackground(Color.MAGENTA);
        residencesButtonsPanel.add(addResidence);
        residencesButtonsPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        residencesButtonsPanel.add(deleteResidence);

        JPanel viewResidencesPanel = new JPanel();
        viewResidencesPanel.setLayout(new BoxLayout(viewResidencesPanel, BoxLayout.Y_AXIS));
        viewResidencesPanel.setBackground(Color.MAGENTA);
        scrollResidences.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollResidences.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        viewResidences.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewResidences.setAlignmentY(Component.CENTER_ALIGNMENT);
        viewResidencesPanel.add(scrollResidences);
        viewResidencesPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        viewResidencesPanel.add(viewResidences);

        JPanel residencesPanel = new JPanel();
        residencesPanel.setLayout(new BoxLayout(residencesPanel, BoxLayout.Y_AXIS));
        residencesPanel.setPreferredSize(new Dimension(SwingConstants.WINDOW_WIDTH/3, SwingConstants.WINDOW_HEIGHT));
        residencesPanel.setBackground(Color.MAGENTA);
        residencesPanel.add(streetPanel);
        residencesPanel.add(numberPanel);
        residencesPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        residencesPanel.add(residencesButtonsPanel);
        residencesPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        residencesPanel.add(viewResidencesPanel);

        JPanel requestsButtonsPanel = new JPanel();
        requestsButtonsPanel.setLayout(new BoxLayout(requestsButtonsPanel, BoxLayout.X_AXIS));
        requestsButtonsPanel.setBackground(Color.MAGENTA);
        addRequest.setAlignmentX(Component.CENTER_ALIGNMENT);
        addRequest.setAlignmentY(Component.CENTER_ALIGNMENT);
        deleteRequest.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteRequest.setAlignmentY(Component.CENTER_ALIGNMENT);
        viewRequests.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewRequests.setAlignmentY(Component.CENTER_ALIGNMENT);
        requestsButtonsPanel.add(viewRequests);
        requestsButtonsPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        requestsButtonsPanel.add(addRequest);
        requestsButtonsPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        requestsButtonsPanel.add(deleteRequest);

        JPanel documentsButtonsPanel = new JPanel();
        documentsButtonsPanel.setLayout(new BoxLayout(documentsButtonsPanel, BoxLayout.X_AXIS));
        documentsButtonsPanel.setBackground(Color.MAGENTA);
        updateRequest.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateRequest.setAlignmentY(Component.CENTER_ALIGNMENT);
        viewDocuments.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewDocuments.setAlignmentY(Component.CENTER_ALIGNMENT);
        documentsButtonsPanel.add(viewDocuments);
        documentsButtonsPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        documentsButtonsPanel.add(updateRequest);

        JPanel requestsPanel = new JPanel();
        requestsPanel.setLayout(new BoxLayout(requestsPanel, BoxLayout.Y_AXIS));
        requestsPanel.setBackground(Color.MAGENTA);
        requestsPanel.setPreferredSize(new Dimension(constants.SwingConstants.WINDOW_WIDTH/3, constants.SwingConstants.WINDOW_HEIGHT));
        scrollRequests.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollRequests.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        requestsPanel.add(scrollRequests);
        viewResidencesPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        requestsPanel.add(requestsButtonsPanel);

        JPanel documentsPanel = new JPanel();
        documentsPanel.setLayout(new BoxLayout(documentsPanel, BoxLayout.Y_AXIS));
        documentsPanel.setBackground(Color.MAGENTA);
        documentsPanel.setPreferredSize(new Dimension(constants.SwingConstants.WINDOW_WIDTH/3, constants.SwingConstants.WINDOW_HEIGHT));
        scrollDocuments.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollDocuments.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        documentsPanel.add(scrollDocuments);
        viewResidencesPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        documentsPanel.add(documentsButtonsPanel);

        JPanel logOutPanel = new JPanel();
        logOutPanel.setLayout(new BoxLayout(logOutPanel, BoxLayout.Y_AXIS));
        logOutPanel.setBackground(Color.MAGENTA);
        logoutLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        logout.setAlignmentX(Component.CENTER_ALIGNMENT);
        logout.setAlignmentY(Component.CENTER_ALIGNMENT);
        logOutPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        logOutPanel.add(logoutLabel);
        logOutPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        logOutPanel.add(logout);
        logOutPanel.add(Box.createRigidArea(new Dimension(0, 50)));

        mainPanel.add(imagePanel, BorderLayout.NORTH);
        mainPanel.add(residencesPanel, BorderLayout.WEST);
        mainPanel.add(documentsPanel, BorderLayout.CENTER);
        mainPanel.add(requestsPanel, BorderLayout.EAST);
        mainPanel.add(logOutPanel, BorderLayout.SOUTH);
        this.setContentPane(mainPanel);

        logout.addActionListener(e -> { eliminateView(); controller.doLogout(); });
        viewDocuments.addActionListener(e -> { List<Object[]> documents = controller.doViewDocuments(); createTable(documents, tableDocuments, new String[]{"TYPE", "DESCRIPTION"});});
        addResidence.addActionListener(e -> controller.addResidence(street.getText(), number.getText()));
        deleteResidence.addActionListener(e -> { String street = getSelectedItemsFromTable(tableResidences, 0); String number = getSelectedItemsFromTable(tableResidences, 1); controller.deleteResidence(street, number); });
        viewResidences.addActionListener(e -> { List<Object[]> residences = controller.getAllResidences(); createTable(residences, tableResidences, new String[]{"STREET", "NUMBER"}); });
        viewRequests.addActionListener(e -> { List<Object[]> requests = controller.getAllRequests(); createTable(requests, tableRequests, new String[]{"EMAIL", "FIRST NAME", "LAST NAME", "STREET", "NUMBER", "TYPE", "DESCRIPTION", "STATUS", "DATE" }); });
        addRequest.addActionListener(e -> { String street = getSelectedItemsFromTable(tableResidences, 0); String number = getSelectedItemsFromTable(tableResidences, 1); String type = getSelectedItemsFromTable(tableDocuments, 0); String description = getSelectedItemsFromTable(tableDocuments, 1); controller.addRequest(street, number, type, description); });
        deleteRequest.addActionListener(e -> { String email = getSelectedItemsFromTable(tableRequests, 0); String street = getSelectedItemsFromTable(tableRequests, 3); String number = getSelectedItemsFromTable(tableRequests, 4); String type = getSelectedItemsFromTable(tableRequests, 5); String description = getSelectedItemsFromTable(tableRequests, 6); String date = getSelectedItemsFromTable(tableRequests, 8); controller.deleteRequest(email, street, number, type, description, date); });
        updateRequest.addActionListener(e-> { String email = getSelectedItemsFromTable(tableRequests, 0); String street = getSelectedItemsFromTable(tableRequests, 3); String number = getSelectedItemsFromTable(tableRequests, 4); String type = getSelectedItemsFromTable(tableRequests, 5); String description = getSelectedItemsFromTable(tableRequests, 6); String date = getSelectedItemsFromTable(tableRequests, 8); controller.updateRequest(email, street, number, type, description, date); });

    }

    private String getSelectedItemsFromTable(JTable table, int column){
        int row = table.getSelectedRow();
        String result = "";
        if(row != -1) {
            result = table.getValueAt(row, column).toString();
        }
        return result;
    }

    public void eliminateView(){
        dispose();
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

    private void init(String userId){

        controller = new RegularUserController(userId);

        image = new ImageIcon("D:\\An3_sem2\\PS(PROGRAMARE SOFTWARE)\\LAB\\ps-2022-30235-a1-Alexandra-Pop-master\\src\\main\\resources\\uiImages\\regularUserImage.png");
        imageLabel = new JLabel(image);

        regularUserLabel = new JLabel("FEREASTRA USER:");
        viewResidences = new JButton("VIEW RESIDENCES");
        viewRequests = new JButton("VIEW REQUESTS");
        viewDocuments = new JButton("VIEW DOCUMENTS");

        addRequest = new JButton("ADD REQUEST");
        deleteRequest = new JButton("DELETE REQUEST");
        updateRequest = new JButton("UPDATE REQUEST");

        logoutLabel = new JLabel("Want to log out?");
        logout = new JButton("LOG OUT");

        streetLabel = new JLabel("STREET: ");
        numberLabel = new JLabel("NUMBER: ");
        street = new JTextField();
        number = new JTextField();
        addResidence = new JButton("ADD RESIDENCE");
        deleteResidence = new JButton("DELETE RESIDENCE");

        tableResidences = new JTable();
        tableRequests = new JTable();
        tableDocuments = new JTable();
        createTable(new ArrayList<Object[]>(), tableDocuments, new String[]{"TYPE", "DESCRIPTION"});
        createTable(new ArrayList<Object[]>(), tableResidences, new String[]{"STREET", "NUMBER"});
        createTable(new ArrayList<Object[]>(), tableRequests, new String[]{"EMAIL", "FIRST NAME", "LAST NAME", "STREET", "NUMBER", "TYPE", "DESCRIPTION", "STATUS", "DATE" });
        tableRequests.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        scrollResidences = new JScrollPane(tableResidences);
        scrollRequests = new JScrollPane(tableRequests);
        scrollDocuments = new JScrollPane(tableDocuments);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        setTitle("Regular User");
        setSize(new Dimension(constants.SwingConstants.WINDOW_WIDTH, SwingConstants.WINDOW_HEIGHT));
        setVisible(true);
        setResizable(false);
        setLocation(new Point(200, 0));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
