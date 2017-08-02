package com.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "cards")
@Data
@NoArgsConstructor
public class Card {

    @NonNull
    @Id
    @Column(nullable = false)
    private Provider provider;

    @NonNull
    @Column(nullable = false)
    private int fields;

    private String description;


}
