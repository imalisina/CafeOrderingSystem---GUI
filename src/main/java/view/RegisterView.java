package view;

import java.security.NoSuchAlgorithmException;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import model.Register;

public class RegisterView extends JFrame {

    // Define register model
    private Register registerModel;

    // Define GUI attributes
    private JButton processRegisterButton;
    private JTextField emailInputField;
    private JTextField usernameInputField;
    private JPasswordField passwordInputField;
    private JTextField fullNameInputField;

    /*
     * Method name : RegisterView
     * Parameters : Register registerModel
     * Description : Alternate constructor
     */
    public RegisterView(Register registerModel) {
        // Define title of the view
        super("Register");
        // initialize the defined register model
        this.registerModel = registerModel;
        // setup other configuration for the register window
        setSize(400, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // initialize and render GUI components of register window - same as setup()
        // method in pre-tutorials
        initComponents();
    }

    /*
     * Method name : initComponents
     * Parameters : None
     * Description : a method render GUI components - same as setup() method in
     * pre-tutorials
     */
    private void initComponents() {
        // Define the main panel of the register window and set it to the layout
        JPanel rootViewPanel = new JPanel();
        rootViewPanel.setLayout(new GridBagLayout());
        GridBagConstraints coordinates = new GridBagConstraints();

        // setting the grid pixel locations
        coordinates.insets = new Insets(10, 10, 10, 10);

        // Define window's title and its font style
        JLabel windowHeader = new JLabel("Register");
        windowHeader.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel usernameLabel = new JLabel("Username:");
        usernameInputField = new JTextField(20);

        JLabel nameLabel = new JLabel("Name:");
        fullNameInputField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordInputField = new JPasswordField(20);

        JLabel emailLabel = new JLabel("Email:");
        emailInputField = new JTextField(20);

        processRegisterButton = new JButton("Register");

        // Define the action handler
        processRegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailInputField.getText();
                String password = passwordInputField.getPassword().toString();
                String username = usernameInputField.getText();
                String name = fullNameInputField.getText();

                // Handle erros during listening for an event
                try {
                    if (registerModel.authenticate(name, username, email, password)) {
                        JOptionPane.showMessageDialog(RegisterView.this, "Name: " + name +
                                "\nUsername: " + username +
                                "\nEmail: " + email +
                                "\nPassword: " + new String(password));
                        try {
                            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        } catch (Exception error) {
                            error.printStackTrace();
                        }

                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                OrderView orderView = new OrderView();
                                orderView.setVisible(true);
                            }
                        });
                    } else {
                        JOptionPane.showMessageDialog(RegisterView.this, "500 - Internal Error");
                    }
                } catch (HeadlessException | NoSuchAlgorithmException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Setup grid coordinations for each element in the layout
        coordinates.gridx = 0;
        coordinates.gridy = 0;
        coordinates.gridwidth = 2;
        coordinates.anchor = GridBagConstraints.CENTER;
        coordinates.weighty = 0.1;
        rootViewPanel.add(windowHeader, coordinates);

        coordinates.gridx = 0;
        coordinates.gridy = 1;
        coordinates.gridwidth = 1;
        coordinates.anchor = GridBagConstraints.LINE_END;
        coordinates.weighty = 0.0;
        rootViewPanel.add(nameLabel, coordinates);

        coordinates.gridx = 1;
        coordinates.gridy = 1;
        coordinates.anchor = GridBagConstraints.LINE_START;
        rootViewPanel.add(fullNameInputField, coordinates);

        coordinates.gridx = 0;
        coordinates.gridy = 2;
        coordinates.anchor = GridBagConstraints.LINE_END;
        rootViewPanel.add(usernameLabel, coordinates);

        coordinates.gridx = 1;
        coordinates.gridy = 2;
        coordinates.anchor = GridBagConstraints.LINE_START;
        rootViewPanel.add(usernameInputField, coordinates);

        coordinates.gridx = 0;
        coordinates.gridy = 3;
        coordinates.anchor = GridBagConstraints.LINE_END;
        rootViewPanel.add(emailLabel, coordinates);

        coordinates.gridx = 1;
        coordinates.gridy = 3;
        coordinates.anchor = GridBagConstraints.LINE_START;
        rootViewPanel.add(emailInputField, coordinates);

        coordinates.gridx = 0;
        coordinates.gridy = 4;
        coordinates.anchor = GridBagConstraints.LINE_END;
        rootViewPanel.add(passwordLabel, coordinates);

        coordinates.gridx = 1;
        coordinates.gridy = 4;
        coordinates.anchor = GridBagConstraints.LINE_START;
        rootViewPanel.add(passwordInputField, coordinates);

        coordinates.gridx = 0;
        coordinates.gridy = 5;
        coordinates.gridwidth = 2;
        coordinates.anchor = GridBagConstraints.CENTER;
        coordinates.weighty = 0.1;
        rootViewPanel.add(processRegisterButton, coordinates);

        // Adding panel to the main window
        add(rootViewPanel);
    }
}