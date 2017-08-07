package com.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity(name = "Card")
@Table(name = "cards")
@Data
@NoArgsConstructor
public class Card {

    @NonNull
    @Min(0)
    @Column(nullable = false)
    private int currentPoints;

    @OneToMany()
    @Column(nullable = false)
    private Set<CardTemplate> cardTemplates;

    private User user;

}
