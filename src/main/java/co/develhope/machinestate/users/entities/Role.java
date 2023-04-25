package co.develhope.machinestate.users.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String description;


}
