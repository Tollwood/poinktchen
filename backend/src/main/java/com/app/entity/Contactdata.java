package com.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

@Entity(name = "Contactdata")
@Table(name = "contactdata")
@Data
@NoArgsConstructor
public class Contactdata {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NonNull
    @OneToOne()
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @NonNull
    @Column(nullable = false)
    private String telephonenumber;

    @NonNull
    @Email
    @Column(nullable = false)
    private String email;

    @NonNull
    @Column(nullable = false)
    //make own object incl. long and lat
    private String address;

    private String homepage;

    private String openingHours;

    private String informations;



}
