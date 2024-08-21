package eni.demo.demo.module4.dao;

import eni.demo.demo.module4.Aliment;

import java.util.ArrayList;
import java.util.List;

public class DAOAlimentMock implements IDAOAliment {

    @Override
    public List<Aliment> selectAliments() {
        // Initialiser une fausse liste d'aliments
        List<Aliment> aliments = new ArrayList<Aliment>();
        aliments.add(new Aliment("Chocolatine"));
        aliments.add(new Aliment("Beurre Salé"));

        return aliments;
    }
}
