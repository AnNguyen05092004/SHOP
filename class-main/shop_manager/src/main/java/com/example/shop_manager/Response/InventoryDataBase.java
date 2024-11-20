package com.example.shop_manager.Response;

import com.example.shop_manager.Entity.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class InventoryDataBase extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private JButton btnShow;
    private final String URL = "jdbc:mysql://localhost:3306/shop";
    private final String User = "root";
    private final String Password = "an198205";

    public InventoryDataBase() {
        setLayout(new BorderLayout());

        // Khởi tạo mô hình bảng
        String[] columnNames = {"Product ID", "Product Name", "Category", "Price", "Quantity Remaining"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Tạo panel cho các nút
        JPanel panel = new JPanel();
        btnShow = new JButton("Show");
        panel.add(btnShow);

        // Thêm nút "Show" vào panel
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try (Connection connection = DriverManager.getConnection(URL, User, Password);) {
                    String sql = "SELECT * FROM product";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);

                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String category = resultSet.getString("category");
                        double price = resultSet.getDouble("price");
                        int quantity = resultSet.getInt("quantity");

                        Product product = new Product(id, name, category, price, quantity);
                        model.addRow(new Object[]{id, name, category, price, quantity});
                    }
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(table, "Database Error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panel, BorderLayout.SOUTH);
    }


}
