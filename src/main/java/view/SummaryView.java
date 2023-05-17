package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;

import model.Order;

public class SummaryView extends JFrame
{
    private JButton summaryButton;
    private JButton viewPriceButton;
    private JButton exitButton;
    private Order orderModel;

    public SummaryView(Order ordermodel) {
        super("Order Summary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        this.orderModel = ordermodel;
        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Order Summary");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        summaryButton = new JButton("View Summary");
        summaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add place order logic here
                String summary = orderModel.displayOrderSummary();
                JOptionPane.showMessageDialog(SummaryView.this, "Order Summary:\n" + summary);
            }
        });

        viewPriceButton = new JButton("View Price");
        viewPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add place order logic here
                String price = orderModel.displayTotalPrice();
                JOptionPane.showMessageDialog(SummaryView.this, "Total Price:\n" + price);
            }
        });

        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add place order logic here
                JOptionPane.showMessageDialog(SummaryView.this, "THANK YOU!!");
                System.exit(0);
            }
        });


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(summaryButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(viewPriceButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(exitButton, gbc);

        add(mainPanel);
    }
}
