package com.yildiz.Cryptology.Cryptology.Controller;

import com.yildiz.Cryptology.Cryptology.Model.PasswordEncrypt;
import com.yildiz.Cryptology.Cryptology.Service.PasswordEncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("https://criptology.herokuapp.com")
@RequestMapping(value = "encryptpassword")
public class PasswordEncryptController {
    @Autowired
    PasswordEncryptService passwordEncryptService;

    @GetMapping("")
    public List<PasswordEncrypt> listedAll(){
        return passwordEncryptService.listAll();
    }
    @PostMapping("")
    public void saveAll(@RequestBody PasswordEncrypt passwordEncrypt){
        passwordEncryptService.savePassEncrypt(passwordEncrypt);

    }
    @GetMapping("/find")
    public String findPass(@RequestParam("passNumber") String passNumber){
        passwordEncryptService.changeString(passNumber);
        return "pass";
    }



}
