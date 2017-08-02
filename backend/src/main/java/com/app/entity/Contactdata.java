package com.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "contactdata")
@Data
@NoArgsConstructor
public class Contactdata {

    @NonNull
    @Id
    @GeneratedValue
    private String id;

    @NonNull
    @Column(nullable = false)
    private String telephonenumber;

    @NonNull
    @Email
    @Column(nullable = false, unique = true)
    private String email;


    @NonNull
    @Column(nullable = false)
    //make own object incl. long and lat
    private String address;



    private String homepage;

    private String openingHours;

    private String informations;



}
