package com.yildiz.Cryptology.Cryptology.Service.imp;

import com.yildiz.Cryptology.Cryptology.Model.Decrypt;
import com.yildiz.Cryptology.Cryptology.Model.Encrypt;
import com.yildiz.Cryptology.Cryptology.Repositories.DecryptRepository;
import com.yildiz.Cryptology.Cryptology.Repositories.EncryptRepository;
import com.yildiz.Cryptology.Cryptology.Service.EncryptService;
import com.yildiz.Cryptology.Cryptology.Service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EncrypServiceImp implements EncryptService {

    @Autowired
    EncryptRepository encryptRepository;
    @Autowired
    PasswordService passwordService;
    @Autowired
    DecryptRepository decryptRepository;

    @Override
    public void saveEncryptText(Encrypt encrypt) {
        encryptRepository.save(encrypt);

    }


    @Override
    public Page<Encrypt> allEncrypt(Pageable pageable){

        return encryptRepository.findAll(pageable);

    }

    @Override
    public String EncryptText(Encrypt encrypt){

        //Kullanıcıdan Alınan Text Array'e Çevriliyor

        StringBuilder clientText = new StringBuilder();
        clientText.append(encrypt.getTextEncrypt());
        ArrayList<Character> clientTextArray = new ArrayList<>() ;

        System.out.println(clientText);

        for (int k=0;k<clientText.length();k++){
            clientTextArray.add(clientText.charAt(k));
        }

        System.out.println(clientTextArray);

        //-----------------------------------------


        ArrayList<ArrayList<String>> allText = new ArrayList<>() ;
        ArrayList<String> creatingPassText = new ArrayList<>() ;
        ArrayList<String> creatingAlphabet = new ArrayList<>() ;
        ArrayList<String> creatingTextPass=new ArrayList<>();
        ArrayList<String> encrypClientText = new ArrayList<>() ;

        allText=passwordService.createPassword();//PasswordServisten gelen dizi
        creatingAlphabet=allText.get(0);         //Alfabe Dizi haline getirildi
        creatingPassText=allText.get(1);          //Şifreleme yapılacak karıştırılmış Dizi
        creatingTextPass=allText.get(2);          //Oluşturulan Şifre


        System.out.println("alfabe:");
        System.out.println(creatingAlphabet);
        System.out.println("şifrelenicek alfabe:");
        System.out.println(creatingPassText);
        System.out.println("şifre:");
        System.out.println(creatingTextPass);


        //Gelen veriler Stringe çevriliyor
        StringBuilder creatingfirstText = new StringBuilder();
        StringBuilder creatingLastText = new StringBuilder();
        StringBuilder creatingPass = new StringBuilder();



        int size=creatingPassText.size()-1;
        for (int i=0;i<=size;i++){
            creatingfirstText.append(creatingAlphabet.get(i));
            creatingLastText.append(creatingPassText.get(i));

        }

        System.out.println(creatingfirstText);
        System.out.println(creatingLastText);


        //-----------------------------------------

        //String datalar Dizi ye çevriliyor

        ArrayList<Character> x = new ArrayList<>() ;
        ArrayList<Character> y = new ArrayList<>() ;

        for (int k=0;k<creatingLastText.length();k++){
            x.add(creatingfirstText.charAt(k));
            y.add(creatingLastText.charAt(k));
        }


        System.out.println(x);

        System.out.println(y);

        //-----------------------------------------


        //Şifreleme Yapılıyor

        for (Character a:clientTextArray) {
            for (int b=0;b<x.size();b++){
                if (a.equals(x.get(b))){

                    encrypClientText.add(y.get(b).toString());
                }
            }

        }

        //-----------------------------------------

        System.out.println("Şifrelenecek Metin");
        System.out.println(clientText);
        System.out.println("Şifrelenmiş Metin");
        System.out.println(encrypClientText);

        //Şifrenen metin Texte çevriliyor ve Decrypt database e kaydediliyot
        StringBuilder e = new StringBuilder();
        StringBuilder ePass =new StringBuilder();

        for (int i=0;i<=encrypClientText.size()-1;i++){
            e.append(encrypClientText.get(i));
        }

        for (int i=0;i<=creatingTextPass.size()-1;i++){
            ePass.append(creatingTextPass.get(i));
        }

        System.out.println("Şifrelenmiş Metin Text");
        System.out.println(e);

        Decrypt decrypt=new Decrypt();
        decrypt.setTextDecrypt(e.toString());
        decrypt.setPassDecrypt(ePass.toString());
        decryptRepository.save(decrypt);


        //-----------------------------------------
















        return "Metin Şifrelenmiştir...";


    }

}
