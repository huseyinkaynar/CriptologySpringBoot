package com.yildiz.Cryptology.Cryptology.Service;

import com.yildiz.Cryptology.Cryptology.Model.Decrypt;
import com.yildiz.Cryptology.Cryptology.Model.Encrypt;

public interface EncryptService {

    Decrypt EncryptText(Encrypt encrypt);
}
