package com.yildiz.Cryptology.Cryptology.Controller;

import com.yildiz.Cryptology.Cryptology.Model.Encrypt;
import com.yildiz.Cryptology.Cryptology.Service.EncryptService;
import com.yildiz.Cryptology.Cryptology.Service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "encrypt")
public class EncryptController {

    @Autowired
    EncryptService encryptService;
    @Autowired
    PasswordService passwordService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<Page> findAlldecrypt(Pageable pageable){

        Page<Encrypt> resultPage = encryptService.allEncrypt(pageable);
        return new ResponseEntity<>(resultPage,HttpStatus.OK);
    }
    @GetMapping("createpassword")
    @ResponseBody
    public ArrayList<ArrayList<String>> createPassword(){
        return passwordService.createPassword();


    }
    @PostMapping("")
    public String createdecrypt(@RequestBody Encrypt encrypt){
        encryptService.saveEncryptText(encrypt);
        return encryptService.EncryptText(encrypt);

    }

}
