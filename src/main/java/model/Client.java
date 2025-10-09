package model;

public class Client {
    @org.example.model.PrimaryKey private int id;

    private String name;

    /**
     *
     * @param id
     * @param name
     */
    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Client() {
    }
    public Client(int id) {
        this.id = id;
    }
    public Client(String name) {
        this.id=-1;
        this.name = name;
    }
}
