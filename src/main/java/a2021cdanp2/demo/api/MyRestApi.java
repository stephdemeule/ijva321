package a2021cdanp2.demo.api;

import a2021cdanp2.demo.model.beans.StudentBean;
import a2021cdanp2.demo.model.beans.UserBean;
import a2021cdanp2.demo.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
//@RequestMapping("rest")
public class MyRestApi {

    @Autowired
    private UserDao userDao;

    //http://localhost:8080/test
    @GetMapping("/test")
    public String test(HttpServletResponse response) {
        System.out.println("/test");

        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

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

    //http://localhost:8080/createUser?name=toto&pwd=12
    @GetMapping("/createUser")
    public List<UserBean> createUser(
            @RequestParam String name,
            @RequestParam String pwd) {
        System.out.println("/createUser name=" + name + " pwd=" + pwd);

        UserBean user = new UserBean(name, pwd);

        userDao.save(user);

        return userDao.findAll();
    }


}
