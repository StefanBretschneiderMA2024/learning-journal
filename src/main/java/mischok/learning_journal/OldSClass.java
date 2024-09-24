package mischok.learning_journal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

@Entity
public class OldSClass {
    @Id
    private int classID;
    private String name;
    private Date assignDate;
    //variable added to enable admin to change assign date for topic

    public OldSClass(String name){

    }

    public OldSClass(int classID, String name, Date assignDate) {
        this.classID = classID;
        this.name = name;
        this.assignDate = assignDate;
    }
    public OldSClass() {
    }

    public void enterClass(){

    }

    public void leaveClass(){
    }

}

