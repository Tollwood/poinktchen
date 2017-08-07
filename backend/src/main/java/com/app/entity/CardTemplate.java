package com.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity(name = "Cardtemplate")
@Table(name = "card_templates")
@Data
@NoArgsConstructor
public class CardTemplate {

    @NonNull
    @Id
    @GeneratedValue
    private String id;

    @NonNull
    @Column(nullable = false)
    private int maxPoints;

    private String title;

    private String description;


    private Branch branch;


}
