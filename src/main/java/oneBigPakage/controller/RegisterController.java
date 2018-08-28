package oneBigPakage.controller;

import oneBigPakage.DAO.UserDao;
import oneBigPakage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//@Controller    // This means that this class is a Controller
//@RequestMapping(path="/") // This means URL's start with /demo (after entity.Application path)
//public class MainController {
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @GetMapping(path="/add") // Map ONLY GET Requests
//    public @ResponseBody String addNewUser (@RequestParam String name
//            , @RequestParam String email) {
//
//        jdbcTemplate.update("INSERT INTO user (name, email) VALUES (?,?)", name, email);
//        return "Saved";
//    }
//}

@Controller
@RequestMapping("/")
public class RegisterController {
    @Autowired
    UserDao userDao;

    @GetMapping(path="/register")
    public String greetingForm(Model model) {
        System.out.println("(.)(.)");
        model.addAttribute("user", new User());
        System.out.println("8=======>");
        return "user";
    }

    @PostMapping(path="/register")
    public String greetingSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        userDao.addNewUser(user);
        return "result";
    }

}