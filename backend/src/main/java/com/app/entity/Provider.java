package com.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "providers")
@Data
@NoArgsConstructor
public class Provider {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    private Card card;
    private String description;
    private Contactdata contactdata;
}
