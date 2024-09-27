package mischok.learning_journal.SClassOperations;


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
public class SClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classID;  // Unique identifier for the class
    private String name;
    private LocalDate assignDate;
    private String formattedAssignDate;

    // default constructor
    public SClass() {}

    // constructor with meat
    public SClass(String name) {
        this.name = name;
        this.assignDate = LocalDate.now();  // Default to the current date
    }

    public SClass(int classID, String name, LocalDate assignDate) {
        this.classID = classID;
        this.name = name;
        this.assignDate = assignDate;
    }

    public void enterClass(){

    }

    public void leaveClass(){
    }

}
