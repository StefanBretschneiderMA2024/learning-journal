package mischok.learning_journal;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class  Controller {

    @GetMapping("/")
    public String home() {
        return "index";
    }




}
