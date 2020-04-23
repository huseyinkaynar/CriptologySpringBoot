package com.yildiz.Cryptology.Cryptology.Service;

import com.yildiz.Cryptology.Cryptology.Model.Decrypt;
import com.yildiz.Cryptology.Cryptology.Model.Encrypt;
import com.yildiz.Cryptology.Cryptology.Model.Mail;

public interface EncryptService {

    Decrypt EncryptText(Encrypt encrypt);
    void sendMail(Mail mail);


}
