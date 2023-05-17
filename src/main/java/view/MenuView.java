package view;

import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import model.Order;

public class MenuView extends JFrame {
    // Define Order model
    private Order orderModel;

    // Define food categories collection
    private String[] categories = { "Breakfast", "Lunch", "Fast Food" };

    // Define GUI attributes
    private JButton processPlaceOrderButton;
    private JTextField foodChoiceId;
    private JComboBox dropdownItemList;

    /*
     * Method name : MenuView
     * Parameters : None
     * Description : Default constructor
     */
    public MenuView() {
        // Define title of the view
        super("Menu");
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

        // setting the grid pixel locations
        coordinates.insets = new Insets(10, 10, 10, 10);

        // define window's title and its font style
        JLabel windowHeader = new JLabel("Menu");
        windowHeader.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel categoryLabel = new JLabel("Categories:");
        dropdownItemList = new JComboBox(categories);
        dropdownItemList.setEditable(true);

        JLabel choiceLabel = new JLabel("Choice:");
        foodChoiceId = new JTextField(6);

        // define the action handler
        dropdownItemList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFoodCategory = (String) dropdownItemList.getSelectedItem();
                foodChoiceId.setText(selectedFoodCategory);
                String menu = orderModel.displayMealMenu(selectedFoodCategory);
                if (selectedFoodCategory.equals("Breakfast")) {
                    JOptionPane.showMessageDialog(MenuView.this, "Breakfast Menu:\n" + menu);
                } else if (selectedFoodCategory.equals("Lunch")) {
                    JOptionPane.showMessageDialog(MenuView.this, "Lunch Menu:\n" + menu);
                } else {
                    JOptionPane.showMessageDialog(MenuView.this, "Fast Food Menu:\n" + menu);
                }
            }
        });

        processPlaceOrderButton = new JButton("Place Order");

        // define the action handler
        processPlaceOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // activate the place order operation
                PlaceOrderView placeOrderView = new PlaceOrderView();
                // change the visibilty of the view
                placeOrderView.setVisible(true);
            }
        });

        // setup grid cooridinations for each element in the layout
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
        rootViewPanel.add(foodChoiceId, coordinates);

        coordinates.gridx = 0;
        coordinates.gridy = 3;
        coordinates.gridwidth = 2;
        coordinates.anchor = GridBagConstraints.CENTER;
        rootViewPanel.add(processPlaceOrderButton, coordinates);

        // Adding panel to the main window
        add(rootViewPanel);
    }
}
