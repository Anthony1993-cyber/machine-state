package co.develhope.machinestate.auth.controllers;

import co.develhope.machinestate.auth.entities.LoginDTO;
import co.develhope.machinestate.auth.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public void login(@RequestBody LoginDTO loginDTO){
        loginService.login(loginDTO);
    }
}
