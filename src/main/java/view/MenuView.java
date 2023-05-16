package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;


import model.Order;

public class MenuView extends JFrame
{
    private String[] categories = {"Breakfast", "Lunch", "Fast Food"};
    private JComboBox box;
    private JTextField choice;
    private JButton placeOrderButton;
    private Order orderModel;

    public MenuView() {
        super("Menu");
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

        JLabel titleLabel = new JLabel("Menu");
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
                String menu = orderModel.displayMealMenu(category);
                if (category.equals("Breakfast"))
                {
                    JOptionPane.showMessageDialog(MenuView.this, "Breakfast Menu:\n" + menu);
                }
                else if (category.equals("Lunch"))
                {
                    JOptionPane.showMessageDialog(MenuView.this, "Lunch Menu:\n" + menu);
                }
                else
                {
                    JOptionPane.showMessageDialog(MenuView.this, "Fast Food Menu:\n" + menu);
                }
                    
            }
        });

        placeOrderButton = new JButton("Place Order");
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add place order logic here
                
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
        mainPanel.add(placeOrderButton, gbc);

        add(mainPanel);
    }
}
