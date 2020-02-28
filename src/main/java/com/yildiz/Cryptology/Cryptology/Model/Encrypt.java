package com.yildiz.Cryptology.Cryptology.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
public class Encrypt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int passEncrypt;
    private String textEncrypt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "decrypt_id", nullable = false)
    private Decrypt decrypt;

    public Encrypt() {
    }

    public Encrypt(int passEncrypt, String textEncrypt,  Decrypt decrypt) {
        this.passEncrypt = passEncrypt;
        this.textEncrypt = textEncrypt;
        this.decrypt = decrypt;
    }


}
