package com.yildiz.Cryptology.Cryptology.Service;

import com.yildiz.Cryptology.Cryptology.Model.Decrypt;
import com.yildiz.Cryptology.Cryptology.Model.Encrypt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EncryptService {
    void saveEncryptText(Encrypt encrypt);
    Page<Encrypt> allEncrypt(Pageable pageable);
    Decrypt EncryptText(Encrypt encrypt);
}
