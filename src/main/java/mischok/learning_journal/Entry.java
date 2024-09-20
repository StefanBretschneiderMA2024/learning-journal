package mischok.learning_journal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

@Entity
public class Entry {
    @Id
    private int entryID;
    private String content;
    private boolean visibility;
    private int userID;
    private Date date;

    public Entry(){}

    public Entry(int entryID, String content, boolean visibility, Date date, int userID) {
        this.entryID = entryID;
        this.content = content;
        this.visibility = visibility;
        this.date = date;
        this.userID = userID;
    }
}
