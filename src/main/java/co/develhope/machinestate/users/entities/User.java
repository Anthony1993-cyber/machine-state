package co.develhope.machinestate.users.entities;

import co.develhope.machinestate.users.utils.Roles;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String password;
    private LocalDateTime jwtCreatedOn;
    private boolean isActive;
    @Column(length = 36)
    private String activationCode;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")})
    private Set<Role> roles;




}
