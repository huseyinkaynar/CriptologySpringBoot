package com.yildiz.Cryptology.Cryptology.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PasswordEncrypt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String passText;
    @Column
    private String passNumber;


}
