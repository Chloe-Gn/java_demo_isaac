package eni.demo.demo.module4.bll;

import eni.demo.demo.module4.bo.Aliment;
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
     * @Deprecated La méthode sera supprimée dans une version future
     * utilisez plutot cette fonction {@link AlimentManagerV2#getAliments()}
     *
     * @return
     */
    @Deprecated()
    public List<Aliment> getAliments() {

        //Récupérer les aliments de la DAO
        List<Aliment> aliments = daoAliment.selectAliments();

        return aliments;
    }


    public Aliment getById(long id) {

        Aliment aliment = daoAliment.getAlimentById(id);

        return aliment;

    }

    /**
     * Appellera la DAO pour sauvegarder un Aliment
     */

    public void saveAliment(Aliment aliment) {

            daoAliment.saveAliment(aliment);
    }

}
