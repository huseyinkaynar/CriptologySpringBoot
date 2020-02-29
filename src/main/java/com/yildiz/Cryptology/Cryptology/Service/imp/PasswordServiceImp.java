package com.yildiz.Cryptology.Cryptology.Service.imp;

import com.yildiz.Cryptology.Cryptology.Model.Password;
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


    @Override
    public void savePassword(Password password) {
        passwordRepository.save(password);


    }

    @Override
    public Page<Password> allPassword(Pageable pageable) {
        return  passwordRepository.findAll(pageable);
    }

    @Override
    public void createPassword(Password password){
        ArrayList<String> passwordText=new ArrayList<>();
        ArrayList<Long> passwordNumber=new ArrayList<>();

        List<Password> pass=passwordRepository.findAll();
        pass.forEach((a)->{
            passwordText.add(a.getPassword());
            passwordNumber.add(a.getId()-1);

        });
        System.out.println(passwordNumber);
        System.out.println(passwordText);


        Collections.shuffle(passwordNumber);
        System.out.println(passwordNumber);

        int psize=passwordNumber.size()-1;
        String pname ="";
        for (int i=0;i<=psize;i++){
            Long number=passwordNumber.get(i);
            pname+=number;

        }
        System.out.println(pname);

        ArrayList<String> encpasswordText=new ArrayList<>();
        passwordNumber.forEach((k)->{
            encpasswordText.add(passwordText.get(k.intValue()));


        });
        System.out.println(encpasswordText);





        int size=passwordText.size()-1;
        String aname = "";
        for (int i=0;i<=size;i++){
            String name=passwordText.get(i);
            aname+=name;

        }
        System.out.println(aname);

        String bname = "";
        for (int i=0;i<=size;i++){
            String name=encpasswordText.get(i);
            bname+=name;

        }
        System.out.println(bname);










    }
}
