package com.yildiz.Cryptology.Cryptology.Service.imp;

import com.yildiz.Cryptology.Cryptology.Model.Encrypt;
import com.yildiz.Cryptology.Cryptology.Repositories.EncryptRepository;
import com.yildiz.Cryptology.Cryptology.Service.EncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class EncrypServiceImp implements EncryptService {

    @Autowired
    EncryptRepository encryptRepository;
    @Override
    public void saveEncryptText(Encrypt encrypt) {
        encryptRepository.save(encrypt);

    }


    @Override
    public Page<Encrypt> allEncrypt(Pageable pageable){

        return encryptRepository.findAll(pageable);

    }

}
