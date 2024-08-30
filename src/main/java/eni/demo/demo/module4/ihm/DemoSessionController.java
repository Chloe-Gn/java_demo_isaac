package eni.demo.demo.module4.ihm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Arrays;
import java.util.List;


@SessionAttributes ({"basket"})
@Controller
public class DemoSessionController {

    @GetMapping("make-basket")
    public String makeBasket(Model model) {
        // Générer un panier de 3 produits et afficher la page
        // qui affiche le panier (for each)
        List<String> basket = Arrays.asList(
                "Pinte de nutella",
                "Beurre de cacahuète",
                "Cassoulet oeuf");

        model.addAttribute("basket", basket);


        return "basket/show-basket";

    }


    @GetMapping("show-basket-2")
    public String showBasket() {
        return "basket/show-basket";

    }

    @GetMapping("clear-basket")
    public String showBasket(SessionStatus sessionStatus) {

        // Méthode 1 : supprimer individuellement
        // un attribut de session
        // model.addAttribute("basket", null)

        // Méthode 2 : Je nettoie toute la session

        sessionStatus.setComplete();
        // Rediriger vers show basket car nettoyer une sessions
        // c'est appliqué qu'après la réponse de cette url

        return "basket/show-basket";

    }





}
