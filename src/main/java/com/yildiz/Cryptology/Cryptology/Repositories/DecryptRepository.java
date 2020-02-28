package com.yildiz.Cryptology.Cryptology.Repositories;

import com.yildiz.Cryptology.Cryptology.Model.Decrypt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DecryptRepository extends JpaRepository<Decrypt,Long> {

    Decrypt findByIsbn(String isbn);
    Page<Decrypt> findAll(Pageable pageable);


}
