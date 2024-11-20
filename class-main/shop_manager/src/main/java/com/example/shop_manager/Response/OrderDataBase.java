package com.example.shop_manager.Response;

import com.example.shop_manager.Entity.Order;
import com.example.shop_manager.Entity.Product;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderDataBase extends JPanel {
    private String URL = "jdbc:mysql://localhost:3306/shop";
    private String USER = "root";
    private String PASSWORD = "an198205";


    private JTextField txtCustomerId, txtProductId, txtQuantity;
    private JTable orderTable;
    private DefaultTableModel tableModel;
    private ArrayList<Object[]> orderList = new ArrayList<>();
    private HashMap<String, String> customerMap = new HashMap<>();
    private HashMap<String, Double> productMap = new HashMap<>();
    private int currentOrderId = 1; // To generate order ID

    public OrderDataBase() {
        setLayout(new BorderLayout());

        // Updated table to include "Order ID" and "Total"
        String[] columnNames = {"Order ID", "Customer ID", "Customer Name", "Product ID", "Price", "Quantity", "Total"};
        tableModel = new DefaultTableModel(columnNames, 0);
        orderTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(orderTable);
        add(scrollPane, BorderLayout.CENTER);

        // Input form
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Customer ID:"));
        txtCustomerId = new JTextField();
        inputPanel.add(txtCustomerId);

        inputPanel.add(new JLabel("Product ID:"));
        txtProductId = new JTextField();
        inputPanel.add(txtProductId);

        inputPanel.add(new JLabel("Quantity:"));
        txtQuantity = new JTextField();
        inputPanel.add(txtQuantity);

        // Add "Add" Button
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {





            }
        });
        inputPanel.add(btnAdd);

        // Add "Delete" Button
        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = orderTable.getSelectedRow();
                if (selectedRow != -1) {
                    orderList.remove(selectedRow);
                    tableModel.removeRow(selectedRow);





                }
            }
        });
        inputPanel.add(btnDelete);

        // Add "Update" Button
        JButton btnEdit = new JButton("Update");
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = orderTable.getSelectedRow();
                if (selectedRow != -1) {
                    String customerId = (String) tableModel.getValueAt(selectedRow, 1);
                    String productId = (String) tableModel.getValueAt(selectedRow, 3);
                    Double productPrice = (Double) tableModel.getValueAt(selectedRow, 4);
                    int quantity = (Integer) tableModel.getValueAt(selectedRow, 5);

                    // Set values to text fields for editing
                    txtCustomerId.setText(customerId);
                    txtProductId.setText(productId);
                    txtQuantity.setText(String.valueOf(quantity));

                    // After editing, calculate new total amount and update the table
                    double totalAmount = productPrice * Integer.parseInt(txtQuantity.getText());
                    tableModel.setValueAt(totalAmount, selectedRow, 6);








                }
            }
        });
        inputPanel.add(btnEdit);


        JButton btnLoadData = new JButton("LoadData"); // Load data tu database len
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {





            }
        });
        inputPanel.add(btnLoadData);
        add(inputPanel, BorderLayout.EAST);
    }

    private void clearFields() {
        txtCustomerId.setText("");
        txtProductId.setText("");
        txtQuantity.setText("");
    }

}
