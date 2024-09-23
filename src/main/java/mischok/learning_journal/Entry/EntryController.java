package mischok.learning_journal.Entry;

import mischok.learning_journal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {

    @Autowired
    private EntryRepository entryRepository;

    @PostMapping("/add")
    public String addEntry(@ModelAttribute Entry entry, @AuthenticationPrincipal User user) {
        entry.setUserID(user.getUserID()); // Benutzer-ID des eingeloggten Nutzers setzen
        entry.setDate(LocalDate.now()); // Datum auf das aktuelle Datum setzen
        entryRepository.save(entry);
        return "redirect:/entries/form";
    }

    @GetMapping("/all")
    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntry(@PathVariable int id) {
        entryRepository.deleteById(id);
    }
}