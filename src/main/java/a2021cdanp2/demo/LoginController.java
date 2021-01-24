package a2021cdanp2.demo;

import a2021cdanp2.demo.model.beans.UserBean;
import a2021cdanp2.demo.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LoginController {

    //private static final ArrayList<UserBean> userList = new ArrayList<>();

    @Autowired
    private UserDao userDao;

    //http://localhost:8080/login
    @GetMapping("/login")
    public String login(Model model) {
        System.out.println("/login");

        model.addAttribute("userBean", new UserBean());

        return "login";
    }

    //http://localhost:8080/loginSubmit
    @PostMapping("/loginSubmit")
    public String loginSubmit(Model model, @ModelAttribute("userBean") UserBean user) {
        System.out.println("/loginSubmit " + user.getName() + " " + user.getPwd());

        //Controle (nom vide, psw vide)
        String messageErreur = "";
        if (user.getName().isBlank()) {
            messageErreur += "Le pseudo est vide\n";
        } else if (user.getPwd().isBlank()) {
            messageErreur += "Le mot de passe est vide\n";
        } else {

            List<UserBean> userList = userDao.findByName(user.getName());
            //login existe pas on ajoute en base
            if (userList.isEmpty()) {
                //j'ajoute en base
                userDao.save(user);
            }
            //Sinon on teste login/mdp
            else {
                if (!userList.get(0).getPwd().equals(user.getPwd())) {
                    messageErreur += "Mot de passe faux\n";
                }
            }
        }

        if (messageErreur.isBlank()) {
            //-> redirige vers un nouvel html qui affiche les utilisateurs
            model.addAttribute("userList", userDao.findAll());
            model.addAttribute("userConnected", user);
            return "userRegister";
        } else {
            //En cas d'erreur
            model.addAttribute("errorMessage", messageErreur);
            return "login";
        }
    }

    //http://localhost:8080/find?name=toto
    @GetMapping("/find")
    public String find(Model model, String name) {
        System.out.println("/find name=" + name);

        List<UserBean> userList = userDao.findByNameIsContaining(name);

        model.addAttribute("userList", userList);

        return "userRegister";
    }

    //http://localhost:8080/delete?name=toto
    @GetMapping("/delete")
    public String delete(Model model, String name) {
        System.out.println("/delete name=" + name);

        int nbSupp = userDao.deleteByNameIsContaining(name);

        model.addAttribute("errorMessage", nbSupp + " user supprimé(s)");

        return "error";
    }
}
