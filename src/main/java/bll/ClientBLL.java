package bll;

import dao.ClientDAO;
import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ClientBLL {
    private ClientDAO clientDAO;
    public ClientBLL() {
        clientDAO = new ClientDAO();
    }

    /**
     * insert
     * @param client
     */
    public void addClient(Client client) {
        this.clientDAO.insert(client);
    }

    /**
     * pt update si delete
     * @param id
     * @return
     */
    public Client getClient(int id) {
        Client client = clientDAO.findById(id);
        if (client == null) {
            throw new NoSuchElementException("No such client");
        }
        return client;
    }

    /**
     * pt afisarea la tot
     * @return
     */
    public List<Client> getClients() {
        List<Client> clients = clientDAO.findAll();
        if (clients == null) {
            return new ArrayList<Client>();
        }
        return clients;
    }

    /**
     * update
     * @param client
     */
    public void updateClient(Client client) {
        this.clientDAO.update(client);
    }

    /**
     * pt delete
     * @param id
     */
    public void deleteClient(int id) {
        this.clientDAO.delete(id);
    }
}
