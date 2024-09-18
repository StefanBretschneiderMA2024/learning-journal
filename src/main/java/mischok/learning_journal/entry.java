package mischok.learning_journal;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class entry {
    private int entryID;
    private String content;
    private boolean visibility;
    private int userID;
    private Date date;

    public entry(){}

}
