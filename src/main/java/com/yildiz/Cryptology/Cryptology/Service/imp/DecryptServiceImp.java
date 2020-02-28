package com.yildiz.Cryptology.Cryptology.Service.imp;


import com.yildiz.Cryptology.Cryptology.Model.Decrypt;
import com.yildiz.Cryptology.Cryptology.Repositories.DecryptRepository;
import com.yildiz.Cryptology.Cryptology.Service.DecryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class DecryptServiceImp implements DecryptService {
    @Autowired
    DecryptRepository decryptRepository;


    @Override
    public void saveDecryptText(Decrypt decrypt) {
        decryptRepository.save(decrypt);

    }


    @Override
    public Page<Decrypt> allDecrypt(Pageable pageable){

        return decryptRepository.findAll(pageable);

    }
}
