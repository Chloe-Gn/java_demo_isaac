package eni.demo.demo.module4.ihm;


import eni.demo.demo.module4.bo.Aliment;
import eni.demo.demo.module4.bll.AlimentManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoFormController {

    @Autowired
    AlimentManager alimentManager;

    @GetMapping("show-aliment-form")

    public String showAlimentForm(Model model) {

        Aliment aliment = new Aliment("", 1L);

        model.addAttribute("aliment", aliment);

        return "form/form-aliment-page";
    }


    /* Traiter les données qui nous seront envoyées.
     *@return
     */

    @PostMapping("show-aliment-form")
    public String alimentForm(@Valid @ModelAttribute Aliment aliment, BindingResult bindingResult) {

        // Objectif tester la validité de la donnée (contrôle de surface)
        if (bindingResult.hasErrors()) {
            System.out.println("Erreur de contrôle surface");
        }

        //On sauvegarde l'aliment dans la BDD
        alimentManager.saveAliment(aliment);

        return "form/form-aliment-page";

    }

}




