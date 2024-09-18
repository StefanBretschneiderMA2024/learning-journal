package mischok.learning_journal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class user {
    int userID;
    String username;
    String password;
    String firstName;
    String lastName;
    boolean admin;
    String email;

    public user(
            //constructor
            String username,
            String password,
            String firstName,
            String lastName,
            boolean admin){

    }


}
