package com.yildiz.Cryptology.Cryptology.Repositories;

import com.yildiz.Cryptology.Cryptology.Model.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<Password,Long> {
}
