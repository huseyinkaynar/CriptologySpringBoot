package com.yildiz.Cryptology.Cryptology.Service.imp;

import com.yildiz.Cryptology.Cryptology.Model.Decrypt;
import com.yildiz.Cryptology.Cryptology.Model.Encrypt;
import com.yildiz.Cryptology.Cryptology.Model.Mail;
import com.yildiz.Cryptology.Cryptology.Repositories.DecryptRepository;
import com.yildiz.Cryptology.Cryptology.Service.EncryptService;
import com.yildiz.Cryptology.Cryptology.Service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class EncrypServiceImp implements EncryptService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SpringTemplateEngine templateEngine;


    @Autowired
    PasswordService passwordService;
    @Autowired
    DecryptRepository decryptRepository;

    @Value("${text.path}")
    String textFilePath;
    @Value("${template.name}")
    String templateName;
    @Value("${attachment.name}")
    String attachmentName;
    @Value("${mail.subject}")
    String mailSubject;


    Decrypt decrypt=new Decrypt();


    @Override
    public Decrypt EncryptText(Encrypt encrypt){

        //Kullanıcıdan Alınan Text Array'e Çevriliyor

        StringBuilder clientText = new StringBuilder();
        clientText.append(encrypt.getTextEncrypt());
        ArrayList<Character> clientTextArray = new ArrayList<>() ;

        for (int k=0;k<clientText.length();k++){
            clientTextArray.add(clientText.charAt(k));
        }

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


        //Gelen veriler Stringe çevriliyor
        StringBuilder creatingfirstText = new StringBuilder();
        StringBuilder creatingLastText = new StringBuilder();
        StringBuilder creatingPass = new StringBuilder();



        int size=creatingPassText.size()-1;
        for (int i=0;i<=size;i++){
            creatingfirstText.append(creatingAlphabet.get(i));
            creatingLastText.append(creatingPassText.get(i));

        }

        //-----------------------------------------

        //String datalar Dizi ye çevriliyor

        ArrayList<Character> x = new ArrayList<>() ;
        ArrayList<Character> y = new ArrayList<>() ;

        for (int k=0;k<creatingLastText.length();k++){
            x.add(creatingfirstText.charAt(k));
            y.add(creatingLastText.charAt(k));
        }

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

        //Şifrenen metin Texte çevriliyor ve Decrypt database e kaydediliyot
        StringBuilder e = new StringBuilder();
        StringBuilder ePass =new StringBuilder();

        for (int i=0;i<=encrypClientText.size()-1;i++){
            e.append(encrypClientText.get(i));
        }

        for (int i=0;i<=creatingTextPass.size()-1;i++){
            ePass.append(creatingTextPass.get(i));
        }

        decrypt.setTextDecrypt(e.toString());
        decrypt.setPassDecrypt(ePass.toString());
        decryptRepository.save(decrypt);

        //-----------------------------------------

        return decrypt;

    }


    @Override
    public void sendMail(Mail mail) throws IOException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        Context context = new Context();

        final String htmlContent = this.templateEngine.process(templateName, context);
        File file1 = new File(textFilePath);
        if (!file1.exists()) {
            file1.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file1, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write("Şifreniz:"+decrypt.getPassDecrypt());
        bWriter.newLine();
        bWriter.write("Şifrelenmiş Metininiz:"+decrypt.getTextDecrypt());



        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);


            messageHelper.setTo(mail.getToMail());
            messageHelper.setText(htmlContent,true);
            messageHelper.setSubject(mailSubject);

            FileSystemResource file = new FileSystemResource(textFilePath);
            messageHelper.addAttachment(attachmentName,file);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        bWriter.close();

        javaMailSender.send(mimeMessage);
    }





}
