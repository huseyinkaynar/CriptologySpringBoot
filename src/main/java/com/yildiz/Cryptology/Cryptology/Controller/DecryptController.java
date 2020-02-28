package com.yildiz.Cryptology.Cryptology.Controller;


import com.yildiz.Cryptology.Cryptology.Model.Decrypt;
import com.yildiz.Cryptology.Cryptology.Service.DecryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "decrypt")
public class DecryptController {
    @Autowired
    DecryptService decryptService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<Page> findAlldecrypt(Pageable pageable){

        Page<Decrypt> resultPage = decryptService.allDecrypt(pageable);
        return new ResponseEntity<>(resultPage,HttpStatus.OK);
    }

    @PostMapping("")
    public String createdecrypt(@RequestBody Decrypt decrypt){
        decryptService.saveDecryptText(decrypt);
        return "saved";
    }


}
