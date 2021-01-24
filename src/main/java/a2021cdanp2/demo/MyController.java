package a2021cdanp2.demo;

import a2021cdanp2.demo.model.beans.StudentBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MyController {

    public static ArrayList<StudentBean> students = new ArrayList<>();


    //http://localhost:8080/hello
    @GetMapping("/hello")
    public String testHello(Model model) {
        System.out.println("/hello");

        model.addAttribute("message", "Salut");

        return "welcome";
    }

    //http://localhost:8080/add?name=toto&note=18
    @GetMapping("/add")
    public String add(Model model, String name, @RequestParam int note) {
        System.out.println("/add name=" + name + " note=" + note);

        if (name == null || name.isBlank()) {
            model.addAttribute("message", "Le nom est manquant");
        } else {
            students.add(new StudentBean(name, note));
            model.addAttribute("message", "L'étudiant a été ajouté");
        }

        model.addAttribute("studentList", students);

        return "welcome";
    }

    //http://localhost:8080/filter?name=toto&note=18
    @GetMapping("/filter")
    public String filter(Model model, String name, Integer note) {
        System.out.println("/filter name=" + name + " note=" + note);

        ArrayList<StudentBean> filterList = new ArrayList<>();

        for (StudentBean student : students) {
            boolean garde = true;

            if (name != null && !name.equalsIgnoreCase(student.getName())) {
                garde = false;
            } else if (note != null && note != student.getNote()) {
                garde = false;
            }
            if (garde) {
                filterList.add(student);
            }
        }


        model.addAttribute("message", "Filtre name=" + name + " et note=" + note);
        model.addAttribute("studentList", filterList);

        return "welcome";
    }
}
