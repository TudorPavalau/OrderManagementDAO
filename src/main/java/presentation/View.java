package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * view ul principal al aplicatiei care se ocupa de aspectul aplicatiei
 * are toate tabelele,si toate butoanele care se ocupa de adaugari,update uri si delete uri
 */
public class View extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel clientPanel;
    private JPanel productsPanel;
    private JPanel ordersPanel;
    private JTable clientTable;
    private JTable productTable;
    private JTable ordersTable;
    private DefaultTableModel clientTableModel;
    private DefaultTableModel productTableModel;
    private DefaultTableModel ordersTableModel;

    private JTextField clientNameField;
    private JTextField clientIDField;
    private JButton clientInsertButton;
    private JButton clientDeleteButton;
    private JButton clientUpdateButton;

    private JTextField productIDField;
    private JTextField productNameField;
    private JTextField productPriceField;
    private JTextField productStockField;
    private JButton productInsertButton;
    private JButton productDeleteButton;
    private JButton productUpdateButton;

    private JTextField orderIDField;
    private JTextField orderClientIdField;
    private JButton orderInsertButton;
    private JButton orderDeleteButton;

    public View() {
        tabbedPane = new JTabbedPane();
        setContentPane(tabbedPane);
        createClientPanel();
        createProductsPanel();
        createOrdersPanel();
        pack();
        setTitle("Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void createClientPanel() {
        clientPanel = new JPanel();
        tabbedPane.add("Clients",clientPanel);
        clientTableModel = new DefaultTableModel();
        clientTable = new JTable(clientTableModel);
        clientPanel.add(new JScrollPane(clientTable));
        clientNameField = new JTextField();
        clientIDField = new JTextField();
        clientInsertButton = new JButton("Insert");
        clientDeleteButton = new JButton("Delete");
        clientUpdateButton = new JButton("Update");

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0,2));
        formPanel.add(new JLabel("ClientID"));
        formPanel.add(clientIDField);
        formPanel.add(new JLabel("ClientName"));
        formPanel.add(clientNameField);
        formPanel.add(clientInsertButton);
        formPanel.add(clientDeleteButton);
        formPanel.add(clientUpdateButton);

        clientPanel.add(formPanel);
    }
    public void createProductsPanel() {
        productsPanel = new JPanel();
        tabbedPane.add("Products",productsPanel);
        productTableModel = new DefaultTableModel();
        productTable = new JTable(productTableModel);
        productsPanel.add(new JScrollPane(productTable));

        productNameField = new JTextField();
        productIDField = new JTextField();
        productStockField = new JTextField();
        productPriceField = new JTextField();
        productInsertButton = new JButton("Insert");
        productDeleteButton = new JButton("Delete");
        productUpdateButton = new JButton("Update");
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0,2));
        formPanel.add(new JLabel("ProductID"));
        formPanel.add(productIDField);
        formPanel.add(new JLabel("ProductName"));
        formPanel.add(productNameField);
        formPanel.add(new JLabel("ProductPrice"));
        formPanel.add(productPriceField);
        formPanel.add(new JLabel("ProductStock"));
        formPanel.add(productStockField);
        formPanel.add(productInsertButton);
        formPanel.add(productDeleteButton);
        formPanel.add(productUpdateButton);

        productsPanel.add(formPanel);
    }

    public void createOrdersPanel() {
        ordersPanel = new JPanel();
        tabbedPane.add("Orders",ordersPanel);
        ordersTableModel = new DefaultTableModel();
        ordersTable = new JTable(ordersTableModel);
        ordersPanel.add(new JScrollPane(ordersTable));

        orderIDField = new JTextField();
        orderClientIdField = new JTextField();
        orderInsertButton = new JButton("Insert");
        orderDeleteButton = new JButton("Delete");
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0,2));
        formPanel.add(new JLabel("OrderID"));
        formPanel.add(orderIDField);
        formPanel.add(new JLabel("ClientID"));
        formPanel.add(orderClientIdField);
        formPanel.add(orderInsertButton);
        formPanel.add(orderDeleteButton);
        ordersPanel.add(formPanel);
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public JPanel getClientPanel() {
        return clientPanel;
    }

    public JPanel getProductsPanel() {
        return productsPanel;
    }

    public JPanel getOrdersPanel() {
        return ordersPanel;
    }

    public JTable getClientTable() {
        return clientTable;
    }

    public JTable getProductTable() {
        return productTable;
    }

    public JTable getOrdersTable() {
        return ordersTable;
    }

    public DefaultTableModel getClientTableModel() {
        return clientTableModel;
    }

    public DefaultTableModel getProductTableModel() {
        return productTableModel;
    }

    public DefaultTableModel getOrdersTableModel() {
        return ordersTableModel;
    }

    public JTextField getOrderIDField() {
        return orderIDField;
    }

    public JTextField getOrderClientIdField() {
        return orderClientIdField;
    }

    public JButton getOrderInsertButton() {
        return orderInsertButton;
    }

    public JButton getOrderDeleteButton() {
        return orderDeleteButton;
    }

    public JTextField getProductIDField() {
        return productIDField;
    }

    public JTextField getProductNameField() {
        return productNameField;
    }

    public JTextField getProductPriceField() {
        return productPriceField;
    }

    public JTextField getProductStockField() {
        return productStockField;
    }

    public JButton getProductInsertButton() {
        return productInsertButton;
    }

    public JButton getProductDeleteButton() {
        return productDeleteButton;
    }

    public JButton getProductUpdateButton() {
        return productUpdateButton;
    }

    public JTextField getClientNameField() {
        return clientNameField;
    }

    public JTextField getClientIDField() {
        return clientIDField;
    }

    public JButton getClientInsertButton() {
        return clientInsertButton;
    }

    public JButton getClientDeleteButton() {
        return clientDeleteButton;
    }

    public JButton getClientUpdateButton() {
        return clientUpdateButton;
    }
}
