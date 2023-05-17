package view;

import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import model.Order;

public class PlaceOrderView extends JFrame {
    // Define Order model
    private Order orderModel;

    // Define food categories collection
    private String[] categories = { "Breakfast", "Lunch", "Fast Food" };

    // Define GUI attributes
    private JButton processAutoGenerateMealButton;
    private JTextField foodChoiceID;
    private JComboBox dropdownItemList;
    private JButton processCompleteOperationButton;

    /*
     * Method name : PlaceOrderView
     * Parameters : None
     * Description : Default constructor
     */
    public PlaceOrderView() {
        // Define title of the view
        super("Place Order");
        // initialize the defined order model
        orderModel = new Order();
        // setup other configurations for the menu window
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
        // define the main panel of the menu window and set it to the layout
        JPanel rootViewPanel = new JPanel();
        rootViewPanel.setLayout(new GridBagLayout());
        GridBagConstraints coordinates = new GridBagConstraints();

        // setting the grid pixel location
        coordinates.insets = new Insets(10, 10, 10, 10);

        // define window's title and its font style
        JLabel windowHeader = new JLabel("Place Your Order");
        windowHeader.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel categoryLabel = new JLabel("Categories:");
        dropdownItemList = new JComboBox(categories);
        dropdownItemList.setEditable(true);

        JLabel choiceLabel = new JLabel("Choice:");
        foodChoiceID = new JTextField(6);
        
        // define the action handler
        dropdownItemList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCategory = (String) dropdownItemList.getSelectedItem();
                foodChoiceID.setText(selectedCategory);
            }
        });

        processAutoGenerateMealButton = new JButton("Generate Meal");
        // define the action handler
        processAutoGenerateMealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFinalCategory = (String) dropdownItemList.getSelectedItem();
                String generatedMeal = orderModel.autoGenerateMeal(selectedFinalCategory);
                JOptionPane.showMessageDialog(PlaceOrderView.this, "Generated Meal:\n" + generatedMeal);
            }
        });

        processCompleteOperationButton = new JButton("Complete Order");
        // define the action handler
        processCompleteOperationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // activate the summary view operation
                SummaryView orderFinalSummaryView = new SummaryView(orderModel);
                // change the visibility of the view
                orderFinalSummaryView.setVisible(true);

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
        coordinates.gridwidth = 1;
        coordinates.anchor = GridBagConstraints.LINE_END;
        rootViewPanel.add(categoryLabel, coordinates);

        coordinates.gridx = 1;
        coordinates.gridy = 1;
        coordinates.anchor = GridBagConstraints.LINE_START;
        rootViewPanel.add(dropdownItemList, coordinates);

        coordinates.gridx = 0;
        coordinates.gridy = 2;
        coordinates.anchor = GridBagConstraints.LINE_END;
        rootViewPanel.add(choiceLabel, coordinates);

        coordinates.gridx = 1;
        coordinates.gridy = 2;
        coordinates.anchor = GridBagConstraints.LINE_START;
        rootViewPanel.add(foodChoiceID, coordinates);

        coordinates.gridx = 0;
        coordinates.gridy = 3;
        coordinates.gridwidth = 2;
        coordinates.anchor = GridBagConstraints.CENTER;
        rootViewPanel.add(processAutoGenerateMealButton, coordinates);

        coordinates.gridx = 0;
        coordinates.gridy = 4;
        coordinates.anchor = GridBagConstraints.CENTER;
        rootViewPanel.add(processCompleteOperationButton, coordinates);

        // Adding panel to the main window
        add(rootViewPanel);
    }
}
