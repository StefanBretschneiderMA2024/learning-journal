package mischok.learning_journal.Entry;

import mischok.learning_journal.newUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/entries")
public class EntryController {

    @Autowired
    private EntryRepository entryRepository;

    // Home page (if necessary)
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Show form for creating a new entry
    @GetMapping("/new")
    public String showCreateEntryForm(Model model) {
        model.addAttribute("entry", new Entry());
        return "add-entry";  // Returns the form for creating a new entry
    }

    // Handle the submission of a new entry
    @PostMapping("/add")
    public String addEntry(@ModelAttribute Entry entry, @AuthenticationPrincipal newUser newUser) {
        entry.setUserID(newUser.getUserID()); // Set the user ID of the logged-in user
        entry.setDate(LocalDate.now()); // Set the current date
        entryRepository.save(entry);
        return "redirect:/entries";  // Redirect to the list of entries after saving
    }

    // List all entries
    @GetMapping
    public String listEntries(Model model) {
        List<Entry> entries = entryRepository.findAll();
        model.addAttribute("entries", entries);
        return "manage-entries";  // Returns the page to manage entries
    }

    // Show form for editing an entry
    @GetMapping("/edit/{id}")
    public String showEditEntryForm(@PathVariable("id") int id, Model model) {
        Optional<Entry> entry = entryRepository.findById(id);
        if (entry.isPresent()) {
            model.addAttribute("entry", entry.get());
            return "add-entry";  // Reuse the same form for editing
        } else {
            return "redirect:/entries";  // Redirect to the entries list if entry is not found
        }
    }

    // Handle updating an entry
    @PostMapping("/update/{id}")
    public String updateEntry(@PathVariable("id") int id, @ModelAttribute Entry entry) {
        Optional<Entry> existingEntry = entryRepository.findById(id);
        if (existingEntry.isPresent()) {
            Entry updatedEntry = existingEntry.get();
            updatedEntry.setTitle(entry.getTitle());
            updatedEntry.setContent(entry.getContent());
            updatedEntry.setDate(LocalDate.now()); // Optionally, update the date
            entryRepository.save(updatedEntry);
        }
        return "redirect:/entries";  // Redirect to the list of entries after updating
    }

    // Delete an entry
    @GetMapping("/delete/{id}")
    public String deleteEntry(@PathVariable("id") int id) {
        entryRepository.deleteById(id);
        return "redirect:/entries";  // Redirect to the list of entries after deletion
    }
}
