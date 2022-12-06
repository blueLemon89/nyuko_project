package com.spring.nyuko.springfile.model;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private Long account_id;

    @Column(name = "account_name")
    private String account_name;

    @Column(name = "email")
    private String email;

    public Account(){

    }

    public Account(Long account_id, String account_name, String email) {
        super();
        this.account_id = account_id;
        this.account_name = account_name;
        this.email = email;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
