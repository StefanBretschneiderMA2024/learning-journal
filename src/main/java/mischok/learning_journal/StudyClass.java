package mischok.learning_journal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

@Entity
public class StudyClass {
    @Id
    private int classID;
    private String name;
    private Date assignDate;
    //variable added to enable admin to change assign date for topic

    public StudyClass(String name){

    }

    public StudyClass(int classID, String name, Date assignDate) {
        this.classID = classID;
        this.name = name;
        this.assignDate = assignDate;
    }
    public StudyClass() {
    }

    public void enterClass(){

    }

    public void leaveClass(){
    }

}

