package mischok.learning_journal.SClassOperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
public class SClassController {

    @Autowired
    private SClassRepository sClassRepository;

    // create
    @GetMapping("/sclasses/new")
    public String showCreateSClassForm(Model model) {
        model.addAttribute("sclass", new SClass());
        return "createSClass";  // returns the create form
    }

    // create
    @PostMapping("/sclasses")
    public String createSClass(@ModelAttribute SClass sClass) {
        sClassRepository.save(sClass);
        return "redirect:/sclasses";  // idk
    }

    // read
    @GetMapping("/sclasses")
    public String listSClasses(Model model) {
        List<SClass> sclasses = sClassRepository.findAll();
        // Format the assignDate for each SClass
        for (SClass sclass : sclasses) {
            sclass.setFormattedAssignDate(sclass.getAssignDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        model.addAttribute("sclasses", sclasses);
        return "listSClasses";
    }


    // update
    @GetMapping("/sclasses/edit/{classID}")
    public String showEditSClassForm(@PathVariable("classID") int classID, Model model) {
        Optional<SClass> sClass = sClassRepository.findById(classID);
        if (sClass.isPresent()) {
            model.addAttribute("sclass", sClass.get());
            return "editSClass";  // idk
        } else {
            return "redirect:/sclasses";  // list of classes
        }
    }

    // update
    @PostMapping("/sclasses/update/{classID}")
    public String updateSClass(@PathVariable("classID") int classID, @ModelAttribute SClass sClass) {
        Optional<SClass> existingSClass = sClassRepository.findById(classID);
        if (existingSClass.isPresent()) {
            SClass updatedClass = existingSClass.get();
            updatedClass.setName(sClass.getName());
            updatedClass.setAssignDate(sClass.getAssignDate());
            sClassRepository.save(updatedClass);
        }
        return "redirect:/sclasses";  // list of classes?
    }

    // deletee
    @GetMapping("/sclasses/delete/{classID}")
    public String deleteSClass(@PathVariable("classID") int classID) {
        sClassRepository.deleteById(classID);
        return "redirect:/sclasses";  // list of classes
    }
}