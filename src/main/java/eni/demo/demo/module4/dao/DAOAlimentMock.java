package eni.demo.demo.module4.dao;

import eni.demo.demo.module4.bo.Aliment;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
@Profile("mock")
public class DAOAlimentMock implements IDAOAliment {

    List<Aliment> aliments = Arrays.asList(
            new Aliment("Chocolatine", 1),
            new Aliment("Beurre sale", 2));


    @Override
    public List<Aliment> selectAliments() {

        // Initialiser une fausse liste d'aliments

        return aliments;


    }

    @Override
    public Aliment getAlimentById(long id) {

        //Méthode à la mano quand on ne sait pas faire autrement
//        Aliment alimentToFind = null;
//        for (Aliment aliment : aliments){
//            if (aliment.id == id) {
//                alimentToFind = aliment;
//                break;
//            }
//        }

        // Avec un predicate
        // Le x, c'est l'aliment qu'on teste ci dessous
        // on a besoin d'ajouter un findFirst car sinon on a une liste
        // Le find first force le filter à ne récupérer qu'une instance
        // et pas une liste avec une instance


        // on fait ça car on est sur un Mock. On ne fera pas ça quand on aura une
        // vraie BDD.
        // un filter retourne les éléments filtrés qui respectent les conditions

        Aliment alimentToFind = aliments.stream().filter(x -> x.id == id).findFirst().orElse(null);


        // Le code pour récupérer un aliment par son id
        return alimentToFind;
    }

    @Override
    public void saveAliment(Aliment aliment) {

    }

}
