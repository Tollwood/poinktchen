package com.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "Branch")
@Table(name = "branches")
@Data
@NoArgsConstructor
public class Branch {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(nullable = false)
    @Size(max = 50)
    private String name;

    @Size(max = 200)
    private String description;
}
