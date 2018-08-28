package oneBigPakage.controller;

import oneBigPakage.DAO.UserDao;
import oneBigPakage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class RegisterController {
    @Autowired
    UserDao userDao;

    @GetMapping(value="/register")
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping(path="/register")
    public String greetingSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        System.out.println("nester");
        userDao.addNewUser(user);
        System.out.println("nesterenko");
        return "result";
    }
}