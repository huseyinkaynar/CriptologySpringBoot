package com.yildiz.Cryptology.Cryptology.Service.imp;

import com.yildiz.Cryptology.Cryptology.Model.Password;
import com.yildiz.Cryptology.Cryptology.Model.PasswordEncrypt;
import com.yildiz.Cryptology.Cryptology.Repositories.PasswordEncryptRepository;
import com.yildiz.Cryptology.Cryptology.Repositories.PasswordRepository;
import com.yildiz.Cryptology.Cryptology.Service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PasswordServiceImp implements PasswordService {
    @Autowired
    PasswordRepository passwordRepository;
    @Autowired
    PasswordEncryptRepository passwordEncryptRepository;


    @Override
    public void savePassword(Password password) {
        passwordRepository.save(password);
    }

    @Override
    public Page<Password> allPassword(Pageable pageable) {
        return  passwordRepository.findAll(pageable);
    }

    @Override
    public String createPassword(){

        ArrayList<String> passwordText=new ArrayList<>();
        ArrayList<Long> passwordNumber=new ArrayList<>();

        StringBuilder EncPass = new StringBuilder();
        StringBuilder firstText = new StringBuilder();
        StringBuilder lastText = new StringBuilder();

        List<Password> pass=passwordRepository.findAll();
        pass.forEach((a)->{
            passwordText.add(a.getPassword());
            passwordNumber.add(a.getId()-1);

        });

        Collections.shuffle(passwordNumber);

        int psize=passwordNumber.size()-1;
        int size=passwordText.size()-1;

        for (int i=0;i<=psize;i++){
            Long number=passwordNumber.get(i);
            EncPass.append(number);

        }

        ArrayList<String> encPasswordText=new ArrayList<>();
        passwordNumber.forEach((k)->{
            encPasswordText.add(passwordText.get(k.intValue()));


        });

        for (int i=0;i<=size;i++){
            firstText.append(passwordText.get(i));
        }

        for (int i=0;i<=size;i++){
            lastText.append(encPasswordText.get(i));
        }

        savePas(EncPass.toString(), lastText.toString());
        return EncPass.toString();


    }

    @Override
    public void savePas(String passNumber,String passText){
        PasswordEncrypt passwordEncrypt=new PasswordEncrypt();
        passwordEncrypt.setPassNumber(passNumber);
        passwordEncrypt.setPassText(passText);
        passwordEncryptRepository.save(passwordEncrypt);

    }

}
