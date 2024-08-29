package eni.demo.demo.module4.bll;

import eni.demo.demo.module4.Aliment;
import eni.demo.demo.module4.dao.IDAOAliment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlimentManagerV2 {

    @Autowired
    IDAOAliment daoAliment;

    public EniManagerResponse<List<Aliment>> getAliments() {

        // Récupérer les aliments de la DAO
        List<Aliment> aliments = daoAliment.selectAliments();

        // Cas 1 : Succès
        EniManagerResponse<List<Aliment>> response = new EniManagerResponse<List<Aliment>>();
        response.code = "200";
        response.message = "Les aliments ont été récupérés avec succès";
        response.data = aliments;

        return response;
    }

    public EniManagerResponse<Aliment> getById(Long id) {
        // récupérer un aliment via la DAO
        Aliment aliment = daoAliment.selectAlimentById(id);

        // Cas 1 : Erreur 701
        if (aliment == null){
            EniManagerResponse<Aliment> response = new EniManagerResponse<Aliment>();
            response.code = "701";
            response.message = "Impossible de récupérer un aliment inexistant";

            return response;
        }

        // Cas 2 : Succès
        EniManagerResponse<Aliment> response = new EniManagerResponse<Aliment>();
        response.code = "200";
        response.message = "Les aliments ont été récupérés avec succès";
        response.data = aliment;

        return response;
    }
}
