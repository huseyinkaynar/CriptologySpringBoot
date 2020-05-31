package com.yildiz.Cryptology.Cryptology.Controller;


import com.yildiz.Cryptology.Cryptology.Model.Decrypt;
import com.yildiz.Cryptology.Cryptology.Model.Encrypt;
import com.yildiz.Cryptology.Cryptology.Service.DecryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("https://criptology.herokuapp.com")
@RequestMapping(value = "decrypt")
public class DecryptController {
    @Autowired
    DecryptService decryptService;



    @PostMapping("")
    @ResponseBody
    public Encrypt findAlldecryptaaa(@RequestBody Decrypt decrypt){

        return decryptService.decryptText(decrypt);
    }


}
