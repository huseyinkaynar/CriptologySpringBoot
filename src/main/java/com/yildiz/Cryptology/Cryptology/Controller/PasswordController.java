package com.yildiz.Cryptology.Cryptology.Controller;

import com.yildiz.Cryptology.Cryptology.Model.Password;
import com.yildiz.Cryptology.Cryptology.Service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("https://criptology.herokuapp.com")
@RequestMapping(value = "password")
public class PasswordController {
    @Autowired
    PasswordService passwordService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<Page> findAllPass(Pageable pageable){

        Page<Password> resultPage = passwordService.allPassword(pageable);
        return new ResponseEntity<>(resultPage, HttpStatus.OK);
    }
    @PostMapping("")
    public String createPass(@RequestBody Password password){
        passwordService.savePassword(password);
        return "saved";
    }
    @GetMapping("/get")
    public void getPass(){
         passwordService.createPassword();
    }
}
