package a2021cdanp2.demo;

import a2021cdanp2.demo.model.beans.CreationBean;
import a2021cdanp2.demo.model.dao.CreationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StoreController {

    @Autowired
    private CreationDao creationDao;


    //http://localhost:8080/testStore
    @GetMapping("/testStore")
    public String testHello(Model model) {
        System.out.println("/hello");

        return "store";
    }

    //http://localhost:8080/admin
    @GetMapping("/admin")
    public String admin(CreationBean creationBean) {
        System.out.println("/admin");


        return "adminStore";
    }

    @PostMapping("/adminSubmit")
    public String adminSubmit(Model model, CreationBean creationBean) {
        System.out.println("/adminSubmit creacreationBean=" + creationBean);

        String errorMessage = "";

        //Controle des données à faire
        if (creationBean.getName().isBlank()) {
            errorMessage += "Le nom est vide <br>";
        }
        if (creationBean.getDate().isBlank()) {
            errorMessage += "La date est vide<br>";
        }
        if (creationBean.getPwd().equals("toto")) {
            errorMessage += "Mot de passe incorrect<br>";
        }
        if (creationBean.getPrice() == null) {
            errorMessage += "Prix incorrect<br>";
        }

        if (errorMessage.isBlank()) {
            //Pas d'erreur on sauvegarde
            creationDao.save(creationBean);
            model.addAttribute("message", "Création ajoutée");
            return "adminStore";
        } else {
            //En cas d'erreur
            model.addAttribute("errorMessage", errorMessage);
            return "adminStore";
        }

    }

    //http://localhost:8080/store
    @GetMapping("/store")
    public String store(Model model) {
        System.out.println("/store");

        model.addAttribute("creationList", creationDao.findAll());

        return "store";
    }

//    //http://localhost:8080/add?name=toto&note=18
//    @GetMapping("/add")
//    public String add(Model model, String name, @RequestParam int note) {
//        System.out.println("/add name=" + name + " note=" + note);
//
//        if (name == null || name.isBlank()) {
//            model.addAttribute("message", "Le nom est manquant");
//        } else {
//            students.add(new StudentBean(name, note));
//            model.addAttribute("message", "L'étudiant a été ajouté");
//        }
//
//        model.addAttribute("studentList", students);
//
//        return "welcome";
//    }
//
//    //http://localhost:8080/filter?name=toto&note=18
//    @GetMapping("/filter")
//    public String filter(Model model, String name, Integer note) {
//        System.out.println("/filter name=" + name + " note=" + note);
//
//        ArrayList<StudentBean> filterList = new ArrayList<>();
//
//        for (StudentBean student : students) {
//            boolean garde = true;
//
//            if (name != null && !name.equalsIgnoreCase(student.getName())) {
//                garde = false;
//            } else if (note != null && note != student.getNote()) {
//                garde = false;
//            }
//            if (garde) {
//                filterList.add(student);
//            }
//        }
//
//
//        model.addAttribute("message", "Filtre name=" + name + " et note=" + note);
//        model.addAttribute("studentList", filterList);
//
//        return "welcome";
//    }
}
