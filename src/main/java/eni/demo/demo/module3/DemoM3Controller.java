package eni.demo.demo.module3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoM3Controller {

    @Autowired
    IDAO dao;

    @GetMapping("get-viennoiserie")
    public String getViennoiserieHttp() {
        // J'appel la DAO
        // Bad
        //DAOSQLServer daoSQLServer = new DAOSQLServer();
        //String maViennoiserie = daoSQLServer.getViennoiserie();
        // Bad 2
        //String maViennoiserie = DAOFactory.getDAOSQLServer().getViennoiserie();

        // Good
        String maViennoiserie = dao.getViennoiserie();

        // Afficher dans le HTML
        return "todo";
    }
}
