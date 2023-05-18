package view;

import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import model.Order;

public class SummaryView extends JFrame {
    // Define Order model
    private Order orderModel;

    // Define GUI attributes
    private JButton terminateProgramButton;
    private JButton processViewPriceButton;
    private JButton processSummaryButton;

    /*
     * Method name : SummaryView
     * Parameters : Order ordermodel
     * Description : Alternate constructor
     */
    public SummaryView(Order ordermodel) {
        // Define title of the view
        super("Order Summary");
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

        processSummaryButton = new JButton("View Summary");

        // define the action handler
        processSummaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String generatedFullSummary = orderModel.displayOrderSummary();
                JOptionPane.showMessageDialog(SummaryView.this, "Order Summary:\n" + generatedFullSummary);
            }
        });

        processViewPriceButton = new JButton("View Price");
        String generatedTotalPrice = orderModel.displayTotalPrice();

        // define the action handler
        processViewPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(SummaryView.this, "Total Price:\n" + generatedTotalPrice);
            }
        });

        terminateProgramButton = new JButton("Exit");
        terminateProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(SummaryView.this, "THANK YOU!!");
                System.exit(0);
            }
        });

        // setup grid coordinations for each element in the layout
        coordinates.gridx = 0;
        coordinates.gridy = 0;
        coordinates.gridwidth = 2;
        coordinates.anchor = GridBagConstraints.CENTER;
        rootViewPanel.add(windowHeader, coordinates);

        coordinates.gridx = 0;
        coordinates.gridy = 1;
        coordinates.gridwidth = 2;
        coordinates.anchor = GridBagConstraints.CENTER;
        rootViewPanel.add(processSummaryButton, coordinates);

        coordinates.gridx = 0;
        coordinates.gridy = 2;
        coordinates.anchor = GridBagConstraints.CENTER;
        rootViewPanel.add(processViewPriceButton, coordinates);

        coordinates.gridx = 0;
        coordinates.gridy = 3;
        coordinates.anchor = GridBagConstraints.CENTER;
        rootViewPanel.add(terminateProgramButton, coordinates);

        // Adding panel to the main window
        add(rootViewPanel);
    }
}