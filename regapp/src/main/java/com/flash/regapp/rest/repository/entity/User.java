package com.flash.regapp.rest.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "user", catalog = "regapp_database")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Column(name = "user_id")
    public Integer userId;
    @Setter
    @Getter
    @Column(name = "username",nullable = false)
    public String username;
    @Setter
    @Getter
    @Column(name = "surname",nullable = false)
    public String surname;
    @Setter
    @Getter
    @Column(name = "email",nullable = false)
    public String email;
    @Setter
    @Getter
    @Column(name = "password",nullable = false)
    public String password;
    @Setter
    @Getter
    @Column(name = "password_reset_code",nullable = false)
    public String passwordResetCode;

}
