package mischok.learning_journal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class OldTopic {
    @Id
    private int topicID;
    private String name;
    private int classID;

    public OldTopic() {
    }

    public OldTopic(int topicID, String name, int classID) {
        this.topicID = topicID;
        this.name = name;
        this.classID = classID;
    }
}
