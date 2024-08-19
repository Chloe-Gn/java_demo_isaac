package eni.demo.demo.module3;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("mysql")
@Component
public class DAOMySQL implements IDAO {

    public String getViennoiserie() {
        return "Pizza Ananas Nutella Crevette";
    }
}