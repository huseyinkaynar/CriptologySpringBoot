package com.yildiz.Cryptology.Cryptology.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
public class Decrypt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String textDecrypt;
    @Column(unique = true)
    private String isbn;

    @OneToMany(mappedBy = "decrypt", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Encrypt> encrypts;

    public Decrypt() {
    }

    public Decrypt(String textDecrypt,  String isbn) {
        this.textDecrypt = textDecrypt;
        this.isbn = isbn;
    }
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String decryptText;
    @Column
    private int decryptPassword;

    @ManyToMany
    @JoinColumn
    private Encrypt encrypt;
    public  Decrypt(String decryptText,int decryptPassword){
        this.decryptText=decryptText;
        this.decryptPassword=decryptPassword;
    }
*/


}
