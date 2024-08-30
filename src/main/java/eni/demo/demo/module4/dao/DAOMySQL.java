package eni.demo.demo.module4.dao;

import eni.demo.demo.module4.bo.Aliment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@Profile("mysql")
public class DAOMySQL implements IDAOAliment {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // ci dessous, RowMapper<Aliment>, c'est la généricité. Ce n'est pas une liste.
    static final RowMapper<Aliment> ALIMENT_ROW_MAPPER = new RowMapper<Aliment>() {
        @Override
        public Aliment mapRow(ResultSet rs, int rowNum) throws SQLException {
            Aliment aliment = new Aliment();

            aliment.id = rs.getLong("id");
            aliment.name = rs.getString("name");

            return aliment;
        }
    };

    @Override
    public List<Aliment> selectAliments() {

        return jdbcTemplate.query("SELECT * FROM aliments", ALIMENT_ROW_MAPPER);

    }


    public Aliment getAlimentById(long id) {
        List<Aliment> aliments = jdbcTemplate.query("SELECT * FROM aliments WHERE id = ?", ALIMENT_ROW_MAPPER, id);

        // Si on trouve aucun element on retourne null
        if (aliments.size() == 0) {
            return null;
        }

        //Retourner le premier element
        return aliments.get(0);
    }

    @Override
    public void saveAliment(Aliment aliment) {

        //Tester s'il existe en base, si OUI => Update, si NON => Insert

        if (getAlimentById(aliment.id) != null) {

            jdbcTemplate.update("UPDATE aliments SET name = ? WHERE id = ?", aliment.name, aliment.id);

            // Ps : Return = Arreter la fonction
            return;
        }


        jdbcTemplate.update("INSERT INTO aliments(id, name) VALUES (?,?)", aliment.id, aliment.name);

    }

    ;
}
