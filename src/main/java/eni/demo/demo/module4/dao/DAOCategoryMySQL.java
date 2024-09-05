package eni.demo.demo.module4.dao;

import eni.demo.demo.module4.bo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOCategoryMySQL implements IDAOCategory {

    // Raccourci pour instancier un objet.
    // On peut faire ça parce que c'est un Bean Spring
    // C'est Spring qui fait le "new" à notre place
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // equivalent à un autowired
    public DAOCategoryMySQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Category> findAll() {

        String sql = "SELECT id, name FROM category";

// si on a mis les mêmes noms entre la BDD et notre class, on peut déclarer son
        //row mapper comme ci-dessous
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
    }

    @Override
    public Category findById(Long id) {

        //plutôt qu'un "?", on va nommer un paramètre

        String sql= "SELECT id, name FROM category WHERE id = :idCat";

        // on ne peut pas utiliser un jdbcTemplate quand on nomme un paramètre

        // Ci dessous, la méthode pour renseigner plusieurs paramètres
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("idCat", id);

        //ci-dessous, la méthode queryForObject est utilisée car on est sur une query,
        // en mode lecture, pour un objet. Query tout court retourne une liste (flemme)
        return namedParameterJdbcTemplate.queryForObject(sql,map,new BeanPropertyRowMapper<>(Category.class));
    }

    // ecrire dans un premier temps ses requêtes dans MySQL Workbench
    // pour vérifier qu'elles fonctionnent
}


