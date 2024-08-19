package eni.demo.demo.module3;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Profile("sqlserver")
@Component
public class DAOSQLServer implements IDAO{

    public String getViennoiserie() {
        return "Croissants aux ongles de pied";
    }
}
