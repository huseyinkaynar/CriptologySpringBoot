package com.yildiz.Cryptology.Cryptology.Service;

import com.yildiz.Cryptology.Cryptology.Model.Decrypt;
import com.yildiz.Cryptology.Cryptology.Model.Encrypt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DecryptService {
    void saveDecryptText(Decrypt decrypt);
    Page<Decrypt> allDecrypt(Pageable pageable);
    Encrypt decryptText(Decrypt decrypt);


}
