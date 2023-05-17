package view;

import java.security.NoSuchAlgorithmException;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import model.Login;

public class LoginView extends JFrame {

    // Define login model
    private Login loginModel;

    // Define GUI attributes
    private JTextField usernameInputField;
    private JButton processLoginButton;
    private JPasswordField passwordInputField;

    /*
     * Method name : LoginView
     * Parameters : Login loginModel
     * Description : Alternate constructor
     */
    public LoginView(Login loginModel) {
        // Define title of the view
        super("Login");
        // initialize the defined login model
        this.loginModel = loginModel;
        // setup other configuration for the login window
        setSize(400, 250);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // initialize and render GUI components of login window - same as setup() method
        // in pre-tutorials
        initComponents();
    }

    /*
     * Method name : initComponents
     * Parameters : None
     * Description : a method render GUI components - same as setup() method in
     * pre-tutorials
     */
    private void initComponents() {
        // Define the main panel of the login window and set it to the layout
        JPanel rootViewPanel = new JPanel();
        rootViewPanel.setLayout(new GridBagLayout());
        GridBagConstraints coordinates = new GridBagConstraints();

        // setting the grid pixel locations
        coordinates.insets = new Insets(10, 10, 10, 10);

        // Define window's title and its font styles
        JLabel screenHeader = new JLabel("Login");
        screenHeader.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel passwordInputLabel = new JLabel("Password:");
        passwordInputField = new JPasswordField(20);

        JLabel usernameInputLabel = new JLabel("Username:");
        usernameInputField = new JTextField(20);
        
        processLoginButton = new JButton("Login");

        // Define the action handler
        processLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameInputField.getText();
                String password = passwordInputField.getPassword().toString();

                // Handle errors during listening for an event
                try {
                    if (loginModel.authenticate(username, password)) {
                        JOptionPane.showMessageDialog(LoginView.this,
                                "Username: " + username + "\nPassword: " + new String(password));
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
                        JOptionPane.showMessageDialog(LoginView.this, "401 - Unauthorized User");
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
        rootViewPanel.add(screenHeader, coordinates);

        coordinates.gridx = 0;
        coordinates.gridy = 1;
        coordinates.gridwidth = 1;
        coordinates.anchor = GridBagConstraints.LINE_END;
        rootViewPanel.add(usernameInputLabel, coordinates);

        coordinates.gridx = 1;
        coordinates.gridy = 1;
        coordinates.anchor = GridBagConstraints.LINE_START;
        rootViewPanel.add(usernameInputField, coordinates);

        coordinates.gridx = 0;
        coordinates.gridy = 2;
        coordinates.anchor = GridBagConstraints.LINE_END;
        rootViewPanel.add(passwordInputLabel, coordinates);

        coordinates.gridx = 1;
        coordinates.gridy = 2;
        coordinates.anchor = GridBagConstraints.LINE_START;
        rootViewPanel.add(passwordInputField, coordinates);

        coordinates.gridx = 0;
        coordinates.gridy = 3;
        coordinates.gridwidth = 2;
        coordinates.anchor = GridBagConstraints.CENTER;
        rootViewPanel.add(processLoginButton, coordinates);

        // Adding panel to the main window
        add(rootViewPanel);
    }
}