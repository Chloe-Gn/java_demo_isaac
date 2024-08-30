package eni.demo.demo.module4.bll;


import eni.demo.demo.module4.bo.Aliment;
import eni.demo.demo.module4.dao.IDAOAliment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlimentManagerV2 {

    @Autowired
    IDAOAliment idaoAliment;

    public EniManagerResponse<List<Aliment>> getAliments() {


        List<Aliment> aliments = idaoAliment.selectAliments();

        // Cas 1 : Succès
        return EniManagerResponse.performResponse("200","Les aliments récupérés avec succès", aliments);


//        EniManagerResponse<List<Aliment>> response = new EniManagerResponse<List<Aliment>>();
//        response.code = "200";
//        response.message = "Les aliments ont été récupérés avec succès";
//        response.data = aliments;
//
//        System.out.println(String.format("Response Metier - Code : %s - Message : %s", response.code, response.message));
//
//        return response;
    }


    public EniManagerResponse<Aliment> getById(Long id) {

        // Récupérer l'aliment via la DAO
        Aliment aliment = idaoAliment.getAlimentById(id);

        // La liste des erreurs, c'est que dans le front.
        // Ici, on teste les erreurs une part une.

        // Cas 1 : Erreur

        if (aliment == null){
            return EniManagerResponse.performResponse("701", "Impossible de récupérer un aliment inexistant", null);
        }
//        if (aliment == null) {
//            EniManagerResponse<Aliment> response = new EniManagerResponse<Aliment>();
//            response.code = "701";
//            response.message = "Impossible de récupérer un aliment inexistant";

            // Afficher la réponse métier dans la console/log


            //return response;}




        // Cas 2 : Succès

        return EniManagerResponse.performResponse("200", "Les aliments ont été récupérés avec succèss", aliment);
//        EniManagerResponse<Aliment> response = new EniManagerResponse<Aliment>();
//        response.code = "200";
//        response.message = "Les aliments ont été récupérés avec succès";
//        response.data = aliment;
//
//        return response;

    }
}
