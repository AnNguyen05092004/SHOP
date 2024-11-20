package com.example.shop_manager.Response;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReportDataBase extends JPanel {
    private JTextField txtCustomerID; // TextField for manual input
    private JTable table;
    private DefaultTableModel model;
    private List<String[]> allData; // Store all records from QLBH.txt
    private JLabel lblTotalAmount; // Label to display total amount

    public ReportDataBase() {
        setLayout(new BorderLayout());

        // Initialize table model with "Invoice ID" column added
        String[] columnNames = {"Invoice ID", "Customer ID", "Customer Name", "Product ID", "Price", "Quantity"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Main control panel for buttons and inputs
        JPanel controlPanel = new JPanel(new GridLayout(2, 1)); // Two rows for the layout

        // Row 1: Button for "Print All Invoices"
        JPanel panelRow1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnPrintInvoices = new JButton("Print All Invoices");
        btnPrintInvoices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });
        panelRow1.add(btnPrintInvoices);

        // Row 2: Controls for Enter Customer ID, Search, and Total Amount
        JPanel panelRow2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelRow2.add(new JLabel("Enter Customer ID:"));

        txtCustomerID = new JTextField(10); // Allow manual input
        panelRow2.add(txtCustomerID);

        JButton btnSearchInvoices = new JButton("Search");
        btnSearchInvoices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {




            }
        });
        panelRow2.add(btnSearchInvoices);

        lblTotalAmount = new JLabel("Total Amount: 0.0");
        panelRow2.add(lblTotalAmount);

        // Add rows to the main control panel
        controlPanel.add(panelRow1);
        controlPanel.add(panelRow2);

        // Add the control panel to the bottom of the layout
        add(controlPanel, BorderLayout.SOUTH);
    }

}
