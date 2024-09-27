package com.neoteric.springBootdemo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Table(name = "account",schema = "bank")
@Data
public class AccountEntity {
    public AccountEntity(){
    }
    @Id
    @Column(name = "accountnumber")
    private String accountnumber;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "pan",nullable = false)
    private  String pan;

    @Column(name ="mobilenumber",nullable = false)
    private String mobilenumber;

    @Column(name ="balance",nullable = false)
    private String balance;

    @OneToMany(mappedBy = "accountEntity",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    public List<AccountEntityAddress> accountEntityAddressesList;

}

