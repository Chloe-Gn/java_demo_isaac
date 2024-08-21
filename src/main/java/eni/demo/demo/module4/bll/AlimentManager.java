package eni.demo.demo.module4.bll;

import eni.demo.demo.module4.Aliment;

import java.util.ArrayList;
import java.util.List;

public class AlimentManager {

    /**
     * Le manager qui récupère la liste des Aliments
     * @return
     */
    public List<Aliment> getAliments() {
        // Initialiser une fausse liste d'aliments
        List<Aliment> aliments = new ArrayList<Aliment>();
        aliments.add(new Aliment("Chocolatine"));
        aliments.add(new Aliment("Beurre Salé"));

        return aliments;
    }
}
