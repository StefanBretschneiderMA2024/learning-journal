package mischok.learning_journal;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class classStudy {
    int classID;
    String name;
    Date assignDate;
    //variable added to enable admin to change assign date for topic

    public classStudy(String name){

    }

    public void enterClass(){

    }

    public void leaveClass(){

    }

}

