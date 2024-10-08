package eni.demo.demo.module4.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//@Entity
public class Aliment {

    @NotBlank(message = "Le titre doit être renseigné")
    @Size(min = 2, max = 250, message = "Doit avoir au moins deux caractères")
    public String name;

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    private Category category;

    public Aliment(String name, long id) {
        this.name = name;
        this.id = id;
    }


    public Aliment(String name, Long id, Category category) {
        // Pour appeler le constructeur parent
        this(name, id);
        this.category = category;
    }

    public Aliment() {

    }

    public Aliment(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Aliment{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", category=" + category +
                '}';
    }
}