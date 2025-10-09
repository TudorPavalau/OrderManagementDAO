package bll;

import dao.Order2ProductsDAO;
import model.Order2Products;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Order2ProductsBLL {
    private Order2ProductsDAO order2ProductsDAO;
    public Order2ProductsBLL() {
        order2ProductsDAO = new Order2ProductsDAO();
    }

    /**
     * afisare
     * @return
     */
    public List<Order2Products> getOrders2Products(){
        List<Order2Products> order2Products = order2ProductsDAO.findAll();
        if (order2Products == null) {
            return new ArrayList<>();
        }
        return order2Products;
    }

    /**
     * pt update delete
     * @param id
     * @return
     */
    public Order2Products getOrder2Products(int id) {
        Order2Products order2Products = order2ProductsDAO.findById(id);
        if (order2Products == null) {
            throw new NoSuchElementException("Order not found");
        }
        return order2Products;
    }

    /**
     * insert
     * @param order2Products
     */
    public void insert(Order2Products order2Products) {
        order2ProductsDAO.insert(order2Products);
    }

    /**
     * delete
     * @param id
     */
    public void delete(int id) {
        order2ProductsDAO.delete(id);
    }

    /**
     * nu se foloseste
     * @param order2Products
     */
    public void update(Order2Products order2Products) {
        order2ProductsDAO.update(order2Products);
    }

    /**
     * se fol pt delete
     * @param orderId
     * @return
     */
    public List<Order2Products> getByOrderId(int orderId) {
        List<Order2Products> order2Products = order2ProductsDAO.findAll();
        if (order2Products == null) {
            return new ArrayList<>();
        }
        return order2Products;
    }
}
