package a2021cdanp2.demo;

import a2021cdanp2.demo.model.beans.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class LoginControllerWithValidator {

    private static final ArrayList<UserBean> userList = new ArrayList<>();

    //http://localhost:8080/loginWithValidation
    @GetMapping("/loginWithValidation")
    public String login(UserBean userBean) {
        System.out.println("/loginWithValidation");

        userBean.setName("Toto");

        return "loginWithValidation";
    }

    //http://localhost:8080/loginSubmitWithValidation
    @PostMapping("/loginSubmitWithValidation")
    public String loginSubmit(Model model, @Valid UserBean userBean, BindingResult bindingResult) {
        System.out.println("/loginSubmitWithValidation " + userBean.getName() + " " + userBean.getPwd());

        if (bindingResult.hasErrors()) {
            System.out.println("Erreur : " + bindingResult);
            return "loginWithValidation";
        }

        //Login est déjà pris je regarde le mdp
        UserBean foundUser = null;
        for (UserBean u : userList) {
            if (u.getName().equals(userBean.getName())) {
                foundUser = u;
            }
        }

        String messageErreur = "";
        //je regarde le mot de passe
        if (foundUser != null) {
            //Je connecte (si login est pris et mot de passe est bon)
            if (!foundUser.getPwd().equals(userBean.getPwd())) {
                messageErreur = "Mot de passe faux\n";
            }
        } else {
            //Enregistre (si le login n'est pas pris) -> ajout dans la liste
            //J'ajoute le nouvel utilisateur
            userList.add(userBean);
        }


        if (messageErreur.isBlank()) {
            //-> redirige vers un nouvel html qui affiche les utilisateurs
            model.addAttribute("userList", userList);
            model.addAttribute("userConnected", userBean);

            return "userRegister";
        } else {
            //En cas d'erreur
            model.addAttribute("errorMessage", messageErreur);
            return "loginWithValidation";
        }


    }
}
