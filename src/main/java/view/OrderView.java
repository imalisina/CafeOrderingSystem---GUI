package view;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class OrderView extends JFrame {

    // Define GUI attributes
    private JButton processOrderButton;
    private JButton processBrowseMenuButton;

    /*
     * Method name : OrderView
     * Parameters : None
     * Description : Alternate constructor
     */
    public OrderView() {
        // Define title of the view
        setTitle("Welcome");

        // Setup other configuration
        setSize(400, 250);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // initialize and render GUI components of the window - same as setup() method
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
        // Define the main panel of the window and set it to the layout
        JPanel rootViewPanel = new JPanel();
        rootViewPanel.setLayout(new GridBagLayout());
        GridBagConstraints coordinates = new GridBagConstraints();

        // setting the grid pixel locations
        coordinates.insets = new Insets(10, 10, 10, 10);

        // define window's title and its font style
        JLabel windowHeader = new JLabel("Welcome to Persian Nights Cafe");
        windowHeader.setFont(new Font("Arial", Font.BOLD, 24));

        processBrowseMenuButton = new JButton("Browse Menu");

        // define the action handler
        processBrowseMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(OrderView.this, "Redirecting to Menu . . .");
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        MenuView menuView = new MenuView();
                        menuView.setVisible(true);
                    }
                });
            }
        });

        processOrderButton = new JButton("Place Order");

        // Define the action handler
        processOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(OrderView.this, "Redirecting to the Order . . .");

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        PlaceOrderView placeOrderView = new PlaceOrderView();
                        placeOrderView.setVisible(true);
                    }
                });
            }
        });

        // setup grid coordinations for each element in the layout
        coordinates.gridx = 0;
        coordinates.gridy = 0;
        coordinates.gridwidth = 2;
        coordinates.anchor = GridBagConstraints.CENTER;
        coordinates.weighty = 0.1;
        rootViewPanel.add(windowHeader, coordinates);

        coordinates.gridx = 0;
        coordinates.gridy = 1;
        coordinates.gridwidth = 2;
        coordinates.anchor = GridBagConstraints.CENTER;
        coordinates.weighty = 0.0;
        rootViewPanel.add(processBrowseMenuButton, coordinates);

        coordinates.gridx = 0;
        coordinates.gridy = 2;
        coordinates.gridwidth = 2;
        coordinates.anchor = GridBagConstraints.CENTER;
        rootViewPanel.add(processOrderButton, coordinates);

        // Adding panel to the main window
        add(rootViewPanel);
    }
}