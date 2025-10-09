package bll;

import dao.ProductDAO;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class ProductBLL {
    private ProductDAO productDAO;
    public ProductBLL() {
        productDAO = new ProductDAO();
    }

    /**
     * se ocupa cu afisarea tuturor produselor
     * @return
     */
    public List<Product> getProducts() {
        List<Product> products = productDAO.findAll();
        if (products == null) {
            return new ArrayList<>();
        }
        return products;
    }

    /**
     * e bun pt find id
     * @param id
     * @return
     */
    public Product getProduct(int id) {
        Product product = productDAO.findById(id);
        if (product == null) {
            throw new NoSuchElementException("Product not found");
        }
        return product;
    }

    /**
     * pt insert
     * @param product
     */
    public void insert(Product product) {
        productDAO.insert(product);
    }
    /**
     * pt update
     */
    public void update(Product product) {
        productDAO.update(product);
    }

    /**
     * pt delete
     * @param id
     */
    public void delete(int id) {
        productDAO.delete(id);
    }

}
