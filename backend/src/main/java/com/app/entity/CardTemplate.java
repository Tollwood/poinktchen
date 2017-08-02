package com.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "cardtemplates")
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


}
