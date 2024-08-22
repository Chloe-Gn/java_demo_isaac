package eni.demo.demo.module4;

import eni.demo.demo.module4.bll.AlimentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DemoController {

    @Autowired
    AlimentManager alimentManager;

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
        // Envoyer la liste d'aliments dans le Modèle
        model.addAttribute("aliments", alimentManager.getAliments());

        // Afficher la page
        return "aliments-page";
    }

    @GetMapping("show-aliment/{id}")
    public String showAliment(@PathVariable("id") long id, Model model){
        // Récupérer l'aliment via la manager avec comme paramètre l'id provenant de la requête (URL)
        Aliment aliment = alimentManager.getById(id);

        // Envoyer l'aliment trouvé dans la vue (dans le modèle)
        model.addAttribute("aliment", aliment);

        // Afficher la page detail aliment
        return "detail-aliment-page";
    }

}
