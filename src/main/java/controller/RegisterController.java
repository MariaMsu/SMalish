package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//@Controller    // This means that this class is a Controller
//@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
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
public class RegisterController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping(path="/register")
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        jdbcTemplate.update("INSERT INTO user (name, email) VALUES (?,?)", user.getName(), user.getEmail());
        return "result";
    }

}