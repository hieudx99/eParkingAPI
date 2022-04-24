package com.example.eparking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

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

//    @OneToMany()
//    @JoinColumn(name = "userid", referencedColumnName = "id")
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Car> listCar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleid")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Role role;

}
