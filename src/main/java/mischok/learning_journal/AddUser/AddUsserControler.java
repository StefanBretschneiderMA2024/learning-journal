package mischok.learning_journal.AddUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddUsserControler {

    @Autowired
    private AddUserRepository addUserRepository;

    @GetMapping("/adduser")
    public String showAddUserForm(Model model){
        model.addAttribute("user",new AddUser());
        return "addUser";
    }
    @PostMapping("/addUser")
    public  String addUser(@ModelAttribute AddUser user) {
        addUserRepository.save(user);
        return "redirect:/users";
    }
    @GetMapping("/users")
    public String listUser(Model model){
        model.addAttribute("users",addUserRepository.findAll());
        return "Userliste";
    }
    }
