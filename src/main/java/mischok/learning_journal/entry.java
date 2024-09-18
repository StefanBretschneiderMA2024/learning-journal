package mischok.learning_journal;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class entry {
    int entryID;
    String content;
    boolean visibility;
    int userID;
    Date date;

    public entry(){}

}
