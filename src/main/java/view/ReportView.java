package view;

import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import model.Order;

public class ReportView extends JFrame {
    // Define Order model
    private Order orderModel;

    /*
     * Method name : SummaryView
     * Parameters : Order ordermodel
     * Description : Alternate constructor
     */
    public ReportView(Order ordermodel) {
        // Define title of the view
        super("Real-Time Order Report");
        // initialize the defined order model
        this.orderModel = ordermodel;
        // setup other configuration for the order window
        setSize(400, 300);
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
        // Define the main panel of the Order window and set it to the layout
        JPanel rootViewPanel = new JPanel();
        rootViewPanel.setLayout(new GridBagLayout());
        GridBagConstraints coordinates = new GridBagConstraints();

        // setting the grid pixel locations
        coordinates.insets = new Insets(10, 10, 10, 10);

        // define widnow's title and its font style
        JLabel windowHeader = new JLabel("Order Summary");
        windowHeader.setFont(new Font("Arial", Font.BOLD, 24));

        // setup grid coordinations for each element in the layout
        coordinates.gridx = 0;
        coordinates.gridy = 0;
        coordinates.gridwidth = 2;
        coordinates.anchor = GridBagConstraints.CENTER;
        rootViewPanel.add(windowHeader, coordinates);

        // Adding panel to the main window
        add(rootViewPanel);
    }
}