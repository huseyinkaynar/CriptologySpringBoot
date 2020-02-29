package com.yildiz.Cryptology.Cryptology.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
public class Decrypt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String textDecrypt;
    @Column
    private String passDecrypt;



}
