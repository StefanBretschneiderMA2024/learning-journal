package mischok.learning_journal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class newUser {
    @Id
    private int userID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean admin;
    private String email;

    public newUser(String email, boolean admin, String firstName, String lastName, String password, String username, int userID) {
        this.email = email;
        this.admin = admin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.username = username;
        this.userID = userID;
    }



    public newUser() {
    }
}
