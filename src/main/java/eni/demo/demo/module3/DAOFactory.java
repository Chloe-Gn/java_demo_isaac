package eni.demo.demo.module3;

public class DAOFactory {

    static DAOSQLServer daosqlServer = null;

    static DAOSQLServer getDAOSQLServer() {
        if (daosqlServer == null) {
            daosqlServer = new DAOSQLServer();
        }
        return daosqlServer;
    };
}
