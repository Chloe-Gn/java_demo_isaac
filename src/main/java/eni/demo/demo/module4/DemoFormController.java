package eni.demo.demo.module4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoFormController {

    @GetMapping("show-aliment-form")
    public String showAlimentForm(Model model) {

        // Préparer ce que tu va envoyer dans le formulaire par défaut
        Aliment aliment = new Aliment(-1L, "");

        // Envoyer l'aliment dans le front (dans la réponse)
        // pour le mettre dans le formulaire
        model.addAttribute("aliment", aliment);

        // Afficher la page formulaire
        return "form/form-aliment-page";
    }

    /**
     * Traiter les données qui nous serons envoyé
     * @return
     */
    @PostMapping("aliment-form")
    public String alimentForm(@ModelAttribute Aliment aliment) {

        // Todo : On sauvegarde l'aliment dans la BDD
        System.out.println(String.format("L'aliment %s a été sauvegardé", aliment.name));

        // Afficher la page formulaire
        return "form/form-aliment-page";
    }
}
