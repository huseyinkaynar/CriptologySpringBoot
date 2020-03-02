package com.yildiz.Cryptology.Cryptology.Service;

import com.yildiz.Cryptology.Cryptology.Model.Password;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PasswordService {
    void savePassword(Password password);
    Page<Password> allPassword(Pageable pageable);
    String createPassword();
    void savePas(String passNumber,String passText);
}
