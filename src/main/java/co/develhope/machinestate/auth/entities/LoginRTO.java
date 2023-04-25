package co.develhope.machinestate.auth.entities;

import co.develhope.machinestate.users.entities.User;
import lombok.Data;

@Data
public class LoginRTO {

    private User user;
    private String jwt;
}
