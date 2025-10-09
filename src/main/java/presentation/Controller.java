package presentation;

import bll.ClientBLL;
import bll.Order2ProductsBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import dao.BillDAO;
import model.*;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;

/**
 * Controllerul principal al aplicatiei care se ocupa de toata logica din spate a gui ului
 * face legatura intre toate sub clasele si se foloseste de metodele acestora pentru a
 * a face add insert si delete
 */
public class Controller {
    private View view;
    private ClientBLL clientBLL;
    private OrderBLL orderBLL;
    private ProductBLL productBLL;
    private Order2ProductsBLL order2ProductsBLL;

    public Controller(View view) {
        this.view = view;
        view.getClientTableModel().setColumnIdentifiers(getTableColumnHeaders(Client.class));
        view.getProductTableModel().setColumnIdentifiers(getTableColumnHeaders(Product.class));
        view.getOrdersTableModel().setColumnIdentifiers(getTableColumnHeaders(Order.class));

        clientBLL = new ClientBLL();
        orderBLL = new OrderBLL();
        productBLL = new ProductBLL();
        order2ProductsBLL = new Order2ProductsBLL();

        update();

        view.getClientInsertButton().addActionListener(e -> {
            int id=Integer.parseInt(view.getClientIDField().getText());
            String name=view.getClientNameField().getText();
            clientBLL.addClient(new Client(id, name));
            update();
        });
        view.getClientDeleteButton().addActionListener(e -> {
            int row=view.getClientTable().getSelectedRow();
            if (row==-1) {
                return;
            }
            int id=Integer.parseInt(view.getClientTableModel().getValueAt(row, 0).toString());
            clientBLL.deleteClient(id);
            update();
        });
        view.getClientTable().getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) {
                return;
            }
            int row = view.getClientTable().getSelectedRow();
            if (row == -1) {
                return;
            }
            int id = Integer.parseInt(view.getClientTableModel().getValueAt(row, 0).toString());
            view.getClientIDField().setText(String.valueOf(id));
            view.getClientNameField().setText(view.getClientTableModel().getValueAt(row, 1).toString());
        });
        view.getClientUpdateButton().addActionListener(e -> {
            int id=Integer.parseInt(view.getClientIDField().getText());
            String name=view.getClientNameField().getText();
            clientBLL.updateClient(new Client(id, name));
            update();
        });

        view.getProductInsertButton().addActionListener(e -> {
            int id=Integer.parseInt(view.getProductIDField().getText());
            String name=view.getProductNameField().getText();
            float price=Float.parseFloat(view.getProductPriceField().getText());
            int stock=Integer.parseInt(view.getProductStockField().getText());
            productBLL.insert(new Product(id, name, stock, price));
            update();
        });
        view.getProductDeleteButton().addActionListener(e -> {
            int row=view.getProductTable().getSelectedRow();
            if (row==-1) {
                return;
            }
            int id=Integer.parseInt(view.getProductTableModel().getValueAt(row, 0).toString());
            productBLL.delete(id);
            update();
        });
        view.getProductTable().getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) {
                return;
            }
            int row=view.getProductTable().getSelectedRow();
            if (row==-1) {
                return;
            }
            int id = Integer.parseInt(view.getProductTable().getValueAt(row, 0).toString());
            view.getProductIDField().setText(String.valueOf(id));
            view.getProductNameField().setText(view.getProductTableModel().getValueAt(row, 1).toString());
            view.getProductPriceField().setText(view.getProductTableModel().getValueAt(row, 3).toString());
            view.getProductStockField().setText(view.getProductTableModel().getValueAt(row, 2).toString());
        });

        view.getOrderInsertButton().addActionListener(e -> {
            int orderID=Integer.parseInt(view.getOrderIDField().getText());
            int clientID=Integer.parseInt(view.getOrderClientIdField().getText());
            orderBLL.insert(new Order(orderID, clientID));
            int price=0;
            while (true){
                JPanel panel=new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                JTextField productIDField=new JTextField();
                JTextField productQuantityField=new JTextField();
                panel.add(new JLabel("Product ID"));
                panel.add(productIDField);
                panel.add(new JLabel("Quantity"));
                panel.add(productQuantityField);

                int option=JOptionPane.showConfirmDialog(null,panel,"Baga Produsu",JOptionPane.OK_CANCEL_OPTION);
                if (option==JOptionPane.OK_CANCEL_OPTION) {
                    break;
                }
                int productID=Integer.parseInt(productIDField.getText());
                int quantity=Integer.parseInt(productQuantityField.getText());
                Product p= productBLL.getProduct(productID);
                if (p==null) {
                    JOptionPane.showMessageDialog(null,"Product not found");
                    continue;
                }
                if(p.getStock()<quantity){
                    JOptionPane.showMessageDialog(null,"Quantity is too low");
                    continue;
                }
                price+=p.getPrice()*quantity;
                p.setStock(p.getStock()-quantity);
                productBLL.update(p);
                order2ProductsBLL.insert(new Order2Products(orderID, productID, quantity));
            }
            BillDAO billDAO = new BillDAO();
            billDAO.insert(new Bill(orderID,clientBLL.getClient(clientID).getName(),new Date(System.currentTimeMillis()),price));
            update();
        });

        view.getOrderDeleteButton().addActionListener(e -> {
            int row=view.getOrdersTable().getSelectedRow();
            if (row==-1) {
                return;
            }
            int orderID=Integer.parseInt(view.getOrdersTableModel().getValueAt(row, 0).toString());
            order2ProductsBLL.delete(orderID);
            orderBLL.delete(orderID);
            update();
        });
    }
    private String[] getTableColumnHeaders(Class type) {
        Field[] fields = type.getDeclaredFields();
        String[] columns = Arrays.stream(fields).map(Field::getName).toArray(String[]::new);

        return columns;
    }

    private <T> Object[] getTableFields(T item) {
        Field[] fields = item.getClass().getDeclaredFields();
        return Arrays.stream(fields).map(field -> {
            field.setAccessible(true);
            try {
                return field.get(item);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).toArray();
    }
    public void update(){
        view.getClientTableModel().setRowCount(0);
        view.getProductTableModel().setRowCount(0);
        view.getOrdersTableModel().setRowCount(0);
        clientBLL.getClients().forEach(client -> {
            view.getClientTableModel().addRow(getTableFields(client));
        });
        productBLL.getProducts().forEach(product -> {
            view.getProductTableModel().addRow(getTableFields(product));
        });
        orderBLL.findAll().forEach(order -> {
            view.getOrdersTableModel().addRow(getTableFields(order));
        });
    }
}
