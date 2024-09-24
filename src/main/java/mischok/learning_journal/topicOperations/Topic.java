package mischok.learning_journal.topicOperations;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class  Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topicID;
    private String name;
    private int classID;

    public Topic() {
    }

    public Topic(int topicID, String name, int classID) {
        this.topicID = topicID;
        this.name = name;
        this.classID = classID;
    }
}