package eni.demo.demo.module4.dao;

import eni.demo.demo.module4.Aliment;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("mysql")
@Component
public class DAOAlimentMySQL implements IDAOAliment {

    @Override
    public List<Aliment> selectAliments() {
        return List.of();
    }

    @Override
    public Aliment selectAlimentById(long id) {
        return null;
    }
}
