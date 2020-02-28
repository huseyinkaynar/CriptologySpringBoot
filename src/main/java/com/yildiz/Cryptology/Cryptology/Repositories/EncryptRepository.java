package com.yildiz.Cryptology.Cryptology.Repositories;

import com.yildiz.Cryptology.Cryptology.Model.Decrypt;
import com.yildiz.Cryptology.Cryptology.Model.Encrypt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EncryptRepository extends JpaRepository<Encrypt,Long> {
    List<Encrypt> findByDecrypt(Decrypt decrypt, Sort sort);
    Page<Encrypt> findAll(Pageable pageable);


}
