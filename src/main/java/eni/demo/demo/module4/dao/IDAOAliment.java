package eni.demo.demo.module4.dao;

import eni.demo.demo.module4.bo.Aliment;

import java.util.List;

/**
 * Ca sert uniquement pour avoir plus tard des spécifications
 * Ex: deux DAO qui font la même chose mais pas de la même manière
 * DAOAlimentMock : Récupérer des aliments instanciés à la volée
 * DAOAlimentSQL : Récupérer les aliments select en base de données;
 *
 */

public interface IDAOAliment {


    List<Aliment> selectAliments();

    Aliment getAlimentById(long id);

    void saveAliment(Aliment aliment);

}
