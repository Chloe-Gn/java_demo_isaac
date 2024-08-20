package eni.demo.demo.module4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("chocolatine")
    public String chocolatine() {

        // Retourne le nom du fichier HTML à charger
        // PS: A partir du dossier resources/templates
        // resources/templates est la racine des fichiers HTML
        return "todo";
    }

    // Dans l'annotion XXXMapping, le première paramètre => le nom de l'url
    // exemple "login" => http://monhost:monport/login
    // donc en localhost avec le port 8080 par défaut (en dev) => http://localhost:8080/login
    @GetMapping("login")
    public String showLoginForm(){
        // Retourne le nom du fichier HTML à charger
        // PS: A partir du dossier resources/templates
        // resources/templates est la racine des fichiers HTML
        return "login-page";
    }

}
