package com.yildiz.Cryptology.Cryptology.Service;

import com.yildiz.Cryptology.Cryptology.Model.PasswordEncrypt;

import java.util.List;

public interface PasswordEncryptService {
    List<PasswordEncrypt> listAll();
    void savePassEncrypt(PasswordEncrypt passwordEncrypt);
    List<PasswordEncrypt> findIsbnPass(String passNumber);
    void changeString(String passNumber);
}
