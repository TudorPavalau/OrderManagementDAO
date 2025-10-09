package bll;

import dao.OrderDAO;
import model.Client;
import model.Order;

import java.util.*;

public class OrderBLL {
    private OrderDAO orderDAO;
    public OrderBLL() {
        orderDAO = new OrderDAO();
    }

    /**
     * e bun pt delete sau update
     * @param id
     * @return
     */
    public Order findById(int id) {
        Order order = orderDAO.findById(id);
        if (order == null) {
            throw new NoSuchElementException("Order not found");
        }
        return order;
    }

    /**
     * e bun pt afisare
     * @return
     */
    public List<Order> findAll() {
        List<Order> orders = orderDAO.findAll();
        if (orders == null) {
            return new ArrayList<Order>();
            }
        else {
            return orders;
        }
    }

    /**
     * insert
     * @param order
     */
    public void insert(Order order) {
        orderDAO.insert(order);
    }

    /**
     * update
     * @param order
     */
    public void update(Order order) {
        orderDAO.update(order);
    }

    /**
     * delete
     * @param id
     */
    public void delete(int id) {
        orderDAO.delete(id);
    }
}
