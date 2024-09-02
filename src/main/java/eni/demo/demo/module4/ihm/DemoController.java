package eni.demo.demo.module4.ihm;

import eni.demo.demo.module4.bo.Aliment;
import eni.demo.demo.module4.bll.AlimentManager;
import eni.demo.demo.module4.bll.AlimentManagerV2;
import eni.demo.demo.module4.bll.EniManagerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DemoController {

    @Autowired
   AlimentManager alimentManager;

    @Autowired
    AlimentManagerV2 alimentManagerV2;


    @GetMapping("")
    public String home(){
        return "index";
    }


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
    public String showLoginForm() {
        // Retourne le nom du fichier HTML à charger
        // PS: A partir du dossier resources/templates
        // resources/templates est la racine des fichiers HTML
        return "login-page";
    }

    @GetMapping("show-aliments")
    public String showAliments(Model model) {

        // V1 : Envoyer la liste d'aliments dans le Modèle
        //  model.addAttribute("aliments", alimentManager.getAliments());

        // V2 : On récupère la réponse métier (contrôle métier)
        EniManagerResponse response = alimentManagerV2.getAliments();
        model.addAttribute("aliments", response.data);

        //Afficher la page
        return "aliments-page";
    }


    @GetMapping("show-aliment/{id}")
    // ce qui est écrit entre guillemets, c'est ça qui fera l'id envoyé
    // dans l'url

    //  bien mettre le model à la fin, pas avant le path variable
    public String showAliment(@PathVariable("id") long id, Model model) {
        // on n'utilise que les managers dans le controller
        // donc récuper l'aliment via le manager avec comme paramètre
        // l'id provenant de la requete (URL)

        // V1
        // Aliment aliment = alimentManager.getById(id);

        //        v1
//        if (aliment == null) {
//
//            // ca suffit car un return ça arrête le code
//
//            return "aliment-not-found";
//        }
//
//        model.addAttribute("aliment", aliment);

        // V2

        EniManagerResponse<Aliment> response = alimentManagerV2.getById(id);

        if (response.code.equals("701")) {


            return "aliment-not-found";
        }
        model.addAttribute("aliments", response.data);

        return "detail-aliment-page";
    }

    @GetMapping("demo-debug")
    public String showDemoDebug() {

//        String pseudo1 = "Isaac";
//        String pseudo2 = "SacréSacré";
//
//        pseudo1 = pseudo2;
//        pseudo1 = "Pas 16h30. :'( sniff. Bilan module va piquer pour la peine";

        Aliment a1 = new Aliment("Chocolatine",1l);
        Aliment a2 = new Aliment( "Pain au chocolat",2l);

        a1 = a2;

        a1.name = "Pizza Ananas Nutella Crevette";

        return "todo";
    }



}
