package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;


import model.Order;

public class PlaceOrderView extends JFrame
{
    private String[] categories = {"Breakfast", "Lunch", "Fast Food"};
    private JComboBox box;
    private JTextField choice;
    private JButton completeButton;
    private JButton generateMealButton;
    private Order orderModel;

    public PlaceOrderView() {
        super("Place Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        orderModel = new Order();
        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Place Your Order");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel categoryLabel = new JLabel("Categories:");
        box = new JComboBox(categories);
        box.setEditable(true);

        JLabel choiceLabel = new JLabel("Choice:");
        choice = new JTextField(6);
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add place order logic here
                String category = (String) box.getSelectedItem();
                choice.setText(category);
            }
        });

        generateMealButton = new JButton("Generate Meal");
        generateMealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add place order logic here
                String category = (String) box.getSelectedItem();
                String meal = orderModel.autoGenerateMeal(category);
                JOptionPane.showMessageDialog(PlaceOrderView.this, "Generated Meal:\n" + meal);
            }
        });

        completeButton = new JButton("Complete Order");
        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SummaryView summaryView = new SummaryView(orderModel);
                summaryView.setVisible(true);
                
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(categoryLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(box, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(choiceLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(choice, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(generateMealButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(completeButton, gbc);

        add(mainPanel);
    }
}
