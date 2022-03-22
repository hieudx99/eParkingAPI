package com.example.eparking.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "identity_card")
    private String identityCard;

    @Column(name = "telephone", unique = true)
    private String telephone;

    @Column(name = "address")
    private String address;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

}
