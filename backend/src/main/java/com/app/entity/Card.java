package com.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//many to many relationship between cardsTemplate and User
@Entity(name = "cards")
@Data
@NoArgsConstructor
public class Card {

    @NonNull
    //nullable for int? default to 0????
    @Column(nullable = false)
    private int currentPoints;

    private User user;

    private CardTemplate cardTemplate;

}
