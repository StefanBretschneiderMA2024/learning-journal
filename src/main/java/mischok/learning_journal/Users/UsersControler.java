package mischok.learning_journal.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersControler {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/adduser")
    public String showAddUserForm(Model model){
        model.addAttribute("user",new Users());
        return "addUser";
    }
    @PostMapping("/addUser")
    public  String addUser(@ModelAttribute Users user) {
        usersRepository.save(user);
        return "redirect:/users";
    }
    @GetMapping("/users")
    public String listUser(Model model){
        model.addAttribute("users", usersRepository.findAll());
        return "userListe";
    }
    @GetMapping("/editUser/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "updateUser";
    }

    @GetMapping("/updateUser/{id}")
    public String UpdateUser(@PathVariable("id")long id, @ModelAttribute Users user, Model model ){
        user.setId(id);
        usersRepository.save(user);
        return  "redirect:/users";
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        usersRepository.delete(user);
        return "redirect:/users";
    }
}
