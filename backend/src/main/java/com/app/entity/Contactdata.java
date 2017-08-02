package com.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "contactdata")
@Data
@NoArgsConstructor
public class Contactdata {

    @NonNull
    @Id
    @Column(nullable = false, unique = true)
    private Provider provider;

    @NonNull
    @Column(nullable = false)
    private String telephonenumber;

    @NonNull
    @Column(nullable = false)
    private String address;

    @NonNull
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    private String homepage;

    private String openingHours;

    private String informations;

}
