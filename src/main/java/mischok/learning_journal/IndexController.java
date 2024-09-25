package mischok.learning_journal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class IndexController {

    @GetMapping("/add-entry")
    public String showAddEntryPage() {
        return "add-entry"; // Thymeleaf template add-entry.html in /resources/templates/
    }

    @GetMapping("/addUser")
    public String showAddUserPage() {
        return "addUser"; // Thymeleaf template addUser.html in /resources/templates/
    }

    @GetMapping("/createSClass")
    public String showCreateSClassPage() {
        return "createSClass"; // Thymeleaf template createSClass.html
    }

    @GetMapping("/userListe")
    public String showUserListePage() {
        return "userListe"; // Thymeleaf template userListe.html
    }

    @GetMapping("/updateUser")
    public String showUpdateUserPage() {
        return "updateUser"; // Thymeleaf template updateUser.html
    }
}
