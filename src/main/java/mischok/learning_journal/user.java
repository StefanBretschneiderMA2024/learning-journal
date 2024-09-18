package mischok.learning_journal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class user {
    private int userID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean admin;
    private String email;

    public user(
            //constructor
            String username,
            String password,
            String firstName,
            String lastName,
            boolean admin){

    }


}
