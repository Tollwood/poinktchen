package com.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "providers")
@Data
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    private String description;

    // 1..n -> at least one Branch
    private List<Branch> branches;

}
