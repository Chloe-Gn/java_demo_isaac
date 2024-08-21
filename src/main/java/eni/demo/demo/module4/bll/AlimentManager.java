package eni.demo.demo.module4.bll;

import eni.demo.demo.module4.Aliment;
import eni.demo.demo.module4.dao.IDAOAliment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlimentManager {

    @Autowired
    IDAOAliment daoAliment;

    /**
     * Le manager qui récupère la liste des Aliments
     * @return
     */
    public List<Aliment> getAliments() {
        // récupérer les aliments de la DAO
        List<Aliment> aliments = daoAliment.selectAliments();

        return aliments;
    }
}
