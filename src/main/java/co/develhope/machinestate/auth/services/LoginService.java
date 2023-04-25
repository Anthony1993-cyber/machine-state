package co.develhope.machinestate.auth.services;

import co.develhope.machinestate.auth.entities.LoginDTO;
import co.develhope.machinestate.auth.entities.LoginRTO;
import co.develhope.machinestate.users.entities.User;
import co.develhope.machinestate.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public LoginRTO login(LoginDTO loginDTO){
        if(loginDTO == null) return null;
        User userFromDB = userRepository.findByEmail(loginDTO.getEmail());
        if(userFromDB == null || !userFromDB.isActive()) return null;

        boolean canLogin = this.canUserLogin(userFromDB, loginDTO.getPassword());
        if(!canLogin) return null;

        String jwt = getJwt(userFromDB);
        userFromDB.setJwtCreatedOn(LocalDateTime.now());
        userRepository.save(userFromDB);

        LoginRTO out = new LoginRTO();
        out.setJwt(jwt);
        out.setUser(userFromDB);

        return out;
    }

    public static boolean canUserLogin(User user, String password){
        return user.getPassword().equals(password);
    }

    public static String getJwt(User user){
        return "------------------";
    }


    public String generateJwt(User user) {
        return "Random Jwt";
    }
}
