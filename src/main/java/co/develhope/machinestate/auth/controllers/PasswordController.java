package co.develhope.machinestate.auth.controllers;

import co.develhope.machinestate.auth.entities.RequestPasswordDTO;
import co.develhope.machinestate.auth.entities.RestorePasswordDTO;
import co.develhope.machinestate.auth.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/password")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping("/request")
    public void passwordRequest(@RequestBody RequestPasswordDTO requestPasswordDTO){
        passwordService.request(requestPasswordDTO);

    }

    @PostMapping("/restore")
    public void passwordRestore(@RequestBody RestorePasswordDTO restorePasswordDTO){
        passwordService.restore(restorePasswordDTO);

    }


}
