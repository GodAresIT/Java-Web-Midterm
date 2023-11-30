package com.example.Midterm_Java.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
@jakarta.persistence.Table(name = "account", schema = "midterm_java", catalog = "")
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "accountname")
    private String accountname;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "role")
    private String role;
    @Basic
    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "accountByIduser")
    private Collection<Usershoppingcart> usershoppingcartsById;


    public Account(String accountname, String password, String role, String username) {
        this.accountname = accountname;
        this.password = password;
        this.role = role;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountname='" + accountname + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
