package com.yildiz.Cryptology.Cryptology.Controller;

import com.yildiz.Cryptology.Cryptology.Model.Decrypt;
import com.yildiz.Cryptology.Cryptology.Model.Encrypt;
import com.yildiz.Cryptology.Cryptology.Model.Mail;
import com.yildiz.Cryptology.Cryptology.Service.EncryptService;
import com.yildiz.Cryptology.Cryptology.Service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "encrypt")
public class EncryptController {

    @Autowired
    EncryptService encryptService;
    @Autowired
    PasswordService passwordService;


    @GetMapping("createpassword")
    @ResponseBody
    public ArrayList<ArrayList<String>> createPassword(){
        return passwordService.createPassword();


    }
    @PostMapping("")
    public Decrypt createdecrypt(@RequestBody Encrypt encrypt){
        return encryptService.EncryptText(encrypt);

    }
    @PostMapping("send")
    public void sendEncrypt(@RequestBody Mail mail) throws MessagingException {
         encryptService.sendMail(mail);

    }


}
