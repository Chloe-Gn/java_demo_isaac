package eni.demo.demo.module4.ihm;


import eni.demo.demo.module4.bll.ICategoryManager;
import eni.demo.demo.module4.bo.Aliment;
import eni.demo.demo.module4.bll.AlimentManager;
import eni.demo.demo.module4.bo.Category;
import eni.demo.demo.module4.dao.IDAOCategory;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DemoFormController {

    @Autowired
    AlimentManager alimentManager;

    @Autowired
    ICategoryManager categoryManager;

    @GetMapping("show-aliment-form")

    public String showAlimentForm(Model model) {

        // Ici, pourquoi on a mis "1" pour l'id de l'aliment ?
        Aliment aliment = new Aliment("", 1L);

        model.addAttribute("aliment", aliment);


        List<Category> categories = categoryManager.getCategories();
        model.addAttribute("categories", categories);
        return "form/form-aliment-page";
    }


    /* Traiter les données qui nous seront envoyées.
     *@return
     */

    @PostMapping("show-aliment-form")
    public String alimentForm(@Valid @ModelAttribute Aliment aliment, BindingResult bindingResult) {

        System.out.println("Aliment reçu dans alimentForm =" + aliment);


        // Objectif tester la validité de la donnée (contrôle de surface)
        if (bindingResult.hasErrors()) {
            System.out.println("Erreur de contrôle surface");
        }

        //On sauvegarde l'aliment dans la BDD
        alimentManager.saveAliment(aliment);

        return "redirect:/show-aliment-form";

    }

}




