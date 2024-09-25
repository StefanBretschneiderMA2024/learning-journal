package mischok.learning_journal.Entry;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int entryID;
    private String title;
    private String content;
    private int userID;
    private LocalDate date;
    private String subject;

    public Entry(){}

    public Entry(int entryID, String subject, String content, LocalDate date, int userID) {
        this.entryID = entryID;
        this.subject = subject;
        this.content = content;
        this.date = date;
        this.userID = userID;

    }
}
