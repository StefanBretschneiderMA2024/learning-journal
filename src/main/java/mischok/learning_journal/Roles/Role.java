package mischok.learning_journal.Roles;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mischok.learning_journal.Users.Users;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Users> users = new HashSet<>();
}
