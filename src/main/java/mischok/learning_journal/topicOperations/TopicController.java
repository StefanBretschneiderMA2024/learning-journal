package mischok.learning_journal.topicOperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    // create
    @GetMapping("/new")
    public String showCreateTopicForm(Model model) {
        model.addAttribute("topic", new Topic());
        return "createTopic";  // create form
    }

    // create
    @PostMapping
    public String createTopic(@ModelAttribute Topic topic) {
        topicRepository.save(topic);
        return "redirect:/topics";  // redirect list
    }

    // read
    @GetMapping
    public String listTopics(Model model) {
        model.addAttribute("topics", topicRepository.findAll());
        return "listTopics";  // list
    }

    // edit
    @GetMapping("/edit/{topicID}")
    public String showEditTopicForm(@PathVariable("topicID") int topicID, Model model) {
        Optional<Topic> topic = topicRepository.findById(topicID);
        if (topic.isPresent()) {
            model.addAttribute("topic", topic.get());
            return "editTopic";  // Returns the edit form with the existing topic data
        } else {
            return "redirect:/topics";  // Redirect if topicID is invalid
        }
    }

    // edit
    @PostMapping("/update/{topicID}")
    public String updateTopic(@PathVariable("topicID") int topicID, @ModelAttribute Topic topic) {
        Optional<Topic> existingTopic = topicRepository.findById(topicID);
        if (existingTopic.isPresent()) {
            Topic updatedTopic = existingTopic.get();
            updatedTopic.setName(topic.getName());
            updatedTopic.setClassID(topic.getClassID());
            topicRepository.save(updatedTopic);
        }
        return "redirect:/topics";  // redirect to list
    }

    // delete
    @GetMapping("/delete/{topicID}")
    public String deleteTopic(@PathVariable("topicID") int topicID) {
        topicRepository.deleteById(topicID);  // delete the topic by ID
        return "redirect:/topics";  // redirect after deletion
    }
}
