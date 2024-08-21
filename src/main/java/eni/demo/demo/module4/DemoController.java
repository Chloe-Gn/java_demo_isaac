package eni.demo.demo.module4;

import eni.demo.demo.module4.bll.AlimentManager;
import eni.demo.demo.module4.bll.FactoryManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("show-aliments")
    public String showAliments(Model model){
        // 1 : Ca c'etait sans Factory et sans singleton
        //AlimentManager alimentManager = new AlimentManager();

        // 2 : En Factory à la main (pas singleton)
        // Pas de singleton car le factory actuellement reinstancie à chaque fois le manager
        AlimentManager alimentManager = FactoryManager.getAlimentManager();

        // Envoyer la liste d'aliments dans le Modèle
        model.addAttribute("aliments", alimentManager.getAliments());

        // Afficher la page
        return "aliments-page";
    }

}
