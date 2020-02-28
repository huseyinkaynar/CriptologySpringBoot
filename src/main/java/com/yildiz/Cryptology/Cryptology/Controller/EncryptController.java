package com.yildiz.Cryptology.Cryptology.Controller;

import com.yildiz.Cryptology.Cryptology.Model.Encrypt;
import com.yildiz.Cryptology.Cryptology.Service.EncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "encrypt")
public class EncryptController {

    @Autowired
    EncryptService encryptService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<Page> findAlldecrypt(Pageable pageable){

        Page<Encrypt> resultPage = encryptService.allEncrypt(pageable);
        return new ResponseEntity<>(resultPage,HttpStatus.OK);
    }
    @PostMapping("")
    public String createdecrypt(@RequestBody Encrypt encrypt){
        encryptService.saveEncryptText(encrypt);
        return "saved";
    }
}
