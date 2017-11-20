package pst.kopendakov.servlets.model;

public abstract class Model {
    private int id;

    public Model() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}