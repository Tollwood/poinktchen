package com.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "branches")
@Data
@NoArgsConstructor
public class Branch {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(nullable = false)
    //max length 50
    private String name;

    //maxLenght 200
    // optional
    private String description;

    @OneToOne
    @JoinColumn(name = "contactdata_id")
    private Contactdata contactdata;

    @OneToOne
    @JoinColumn(name = "card_id")
    //0..n
    private List<CardTemplate> cardTemplates;

}
