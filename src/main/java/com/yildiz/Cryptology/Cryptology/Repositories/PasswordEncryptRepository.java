package com.yildiz.Cryptology.Cryptology.Repositories;

import com.yildiz.Cryptology.Cryptology.Model.PasswordEncrypt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PasswordEncryptRepository extends JpaRepository<PasswordEncrypt,Long> {
    List<PasswordEncrypt> findBypassNumber(String passNumber);
}
