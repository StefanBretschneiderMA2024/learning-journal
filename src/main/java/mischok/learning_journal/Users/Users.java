package mischok.learning_journal.Users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mischok.learning_journal.Roles.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Users implements UserDetails { // Implement UserDetails interface

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    // New field for enabled status
    private boolean enabled = true;

    // Relationship to Roles
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    // Implement UserDetails methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Define your logic if needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Define your logic if needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Define your logic if needed
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
