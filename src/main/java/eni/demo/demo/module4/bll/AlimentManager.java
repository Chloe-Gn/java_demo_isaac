package eni.demo.demo.module4.bll;

import eni.demo.demo.module4.Aliment;
import eni.demo.demo.module4.dao.FactoryDAO;
import eni.demo.demo.module4.dao.IDAOAliment;

import java.util.ArrayList;
import java.util.List;

public class AlimentManager {

    /**
     * Le manager qui récupère la liste des Aliments
     * @return
     */
    public List<Aliment> getAliments() {
        // Récupére la couche DAO
        IDAOAliment daoAliment = FactoryDAO.getDAOAliment();

        // récupérer les aliments de la DAO
        List<Aliment> aliments = daoAliment.selectAliments();

        return aliments;
    }
}
