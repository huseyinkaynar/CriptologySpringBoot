package com.yildiz.Cryptology.Cryptology.Service.imp;


import com.yildiz.Cryptology.Cryptology.Model.Decrypt;
import com.yildiz.Cryptology.Cryptology.Model.Encrypt;
import com.yildiz.Cryptology.Cryptology.Model.PasswordEncrypt;
import com.yildiz.Cryptology.Cryptology.Repositories.DecryptRepository;
import com.yildiz.Cryptology.Cryptology.Repositories.EncryptRepository;
import com.yildiz.Cryptology.Cryptology.Repositories.PasswordEncryptRepository;
import com.yildiz.Cryptology.Cryptology.Service.DecryptService;
import com.yildiz.Cryptology.Cryptology.Service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DecryptServiceImp implements DecryptService {
    @Autowired
    DecryptRepository decryptRepository;
    @Autowired
    PasswordEncryptRepository passwordEncryptRepository;
    @Autowired
    PasswordService passwordService;
    @Autowired
    EncryptRepository encryptRepository;


    @Override
    public void saveDecryptText(Decrypt decrypt) {
        decryptRepository.save(decrypt);

    }


    @Override
    public Page<Decrypt> allDecrypt(Pageable pageable){

        return decryptRepository.findAll(pageable);

    }

    @Override
    public Encrypt decryptText(Decrypt decrypt){


        String decryptingArray1;

        decryptingArray1=decrypt.getTextDecrypt();

        System.out.println("Çözülecek Metin:");
        System.out.println(decryptingArray1);

        StringBuilder decryptingPassArray1=new StringBuilder();
        List<PasswordEncrypt> decryptingPass=  passwordEncryptRepository.findBypassNumber(decrypt.getPassDecrypt());
        decryptingPass.forEach((a)->{
            decryptingPassArray1.append(a.getPassText());

        });

        System.out.println("Çözüm Şifresi");
        System.out.println(decryptingPassArray1);
        ArrayList<ArrayList<String>> allText = new ArrayList<>() ;
        ArrayList<String> creatingAlphabet = new ArrayList<>() ;

        allText=passwordService.createPassword();//PasswordServisten gelen dizi
        creatingAlphabet=allText.get(0);

        StringBuilder creatingfirstText = new StringBuilder();

        int size=creatingAlphabet.size()-1;
        for (int i=0;i<=size;i++){
            creatingfirstText.append(creatingAlphabet.get(i));
        }

        System.out.println("Alfabe");
        System.out.println(creatingfirstText);




        ArrayList<Character> y = new ArrayList<>() ;

        for (int k=0;k<creatingfirstText.length();k++){
            y.add(creatingfirstText.charAt(k));
        }



        ArrayList<String> decryptingNewText=new ArrayList<>();

        ArrayList<Character> decryptingArray=new ArrayList<>();


        for (int k=0;k<decryptingArray1.length();k++){
            decryptingArray.add(decryptingArray1.charAt(k));
        }




        for (Character a:decryptingArray) {
            for (int b=0;b<decryptingPassArray1.length();b++){
                if (a.equals(decryptingPassArray1.charAt(b))){

                    decryptingNewText.add(y.get(b).toString());
                }
            }

        }
        System.out.println("Çözülmüş Metin");
        System.out.println(decryptingNewText);

        StringBuilder e = new StringBuilder();

        for (int i=0;i<=decryptingNewText.size()-1;i++){
            e.append(decryptingNewText.get(i));
        }

        System.out.println("Çözülmüş Metin Text");
        System.out.println(e);

        Encrypt encrypt=new Encrypt();
        encrypt.setTextEncrypt(e.toString());
        encrypt.setPassEncrypt(decrypt.getPassDecrypt());
        encryptRepository.save(encrypt);


        return encrypt;






    }
}
