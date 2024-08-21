package eni.demo.demo.module4.dao;

import eni.demo.demo.module4.bll.AlimentManager;

public class FactoryDAO {

    public static IDAOAliment getDAOAliment(){
        return new DAOAlimentMock();
    }
}
