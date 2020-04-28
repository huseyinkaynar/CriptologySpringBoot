package com.yildiz.Cryptology.Cryptology.Service;

import com.yildiz.Cryptology.Cryptology.Model.Decrypt;
import com.yildiz.Cryptology.Cryptology.Model.Encrypt;
import com.yildiz.Cryptology.Cryptology.Model.Mail;

import javax.mail.MessagingException;
import java.io.IOException;

public interface EncryptService {

    Decrypt EncryptText(Encrypt encrypt);
    void sendMail(Mail mail) throws MessagingException, IOException;


}
