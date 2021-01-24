package a2021cdanp2.demo.api;

import a2021cdanp2.demo.model.beans.StudentBean;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("rest")
public class MyRestApi {

    //http://localhost:8080/test
    @GetMapping("/test")
    public String test() {
        System.out.println("/test");
        return "<b>Hello</b>";
    }

    //http://localhost:8080/student
    @GetMapping("/student")
    public StudentBean getStudent() {
        System.out.println("/student");

        StudentBean student = new StudentBean("Toto", 12);
        return student;
    }


    //http://localhost:8080/createStudent?name=toto&note=12
    @GetMapping("/createStudent")
    public StudentBean createStudent(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int note) {
        System.out.println("/createStudent name=" + name + " note=" + note);

        StudentBean student = new StudentBean(name, note);
        return student;
    }

    //http://localhost:8080/addOne
    @PostMapping("/addOne")
    public StudentBean addOne(@RequestBody StudentBean student) {
        System.out.println("/addOne student=" + student);

        student.setNote(student.getNote() + 1);

        return student;
    }


}
