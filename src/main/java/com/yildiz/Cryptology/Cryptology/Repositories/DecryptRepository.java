package com.yildiz.Cryptology.Cryptology.Repositories;

import com.yildiz.Cryptology.Cryptology.Model.Decrypt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DecryptRepository extends JpaRepository<Decrypt,Long> {

    List<Decrypt> findBypassDecrypt(String passDecrypt);



}
