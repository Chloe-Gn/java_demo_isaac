package eni.demo.demo.module4;

public class Aliment {

    public long id;
    public String name;

    public Aliment() {
    }

    public Aliment(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
