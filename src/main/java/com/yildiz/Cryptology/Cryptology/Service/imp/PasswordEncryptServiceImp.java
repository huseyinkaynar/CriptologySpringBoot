package com.yildiz.Cryptology.Cryptology.Service.imp;

import com.yildiz.Cryptology.Cryptology.Model.PasswordEncrypt;
import com.yildiz.Cryptology.Cryptology.Repositories.PasswordEncryptRepository;
import com.yildiz.Cryptology.Cryptology.Service.PasswordEncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PasswordEncryptServiceImp implements PasswordEncryptService {
    @Autowired
    PasswordEncryptRepository passwordEncryptRepository;

    @Override
    public List<PasswordEncrypt> listAll() {
        return passwordEncryptRepository.findAll() ;
    }

    @Override
    public void savePassEncrypt(PasswordEncrypt passwordEncrypt) {
        passwordEncryptRepository.save(passwordEncrypt);

    }
    @Override
    public List<PasswordEncrypt> findIsbnPass(String passNumber){
        return passwordEncryptRepository.findBypassNumber(passNumber);

    }

    @Override
    public void changeString(String passNumber){
        StringBuilder lastText = new StringBuilder();

        List<PasswordEncrypt> as=findIsbnPass(passNumber);
        as.forEach((a)->{
           lastText.append(a.getPassText());

        });


    }
}
