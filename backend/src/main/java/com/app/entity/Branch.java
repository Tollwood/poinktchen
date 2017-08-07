package com.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "Branche")
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

    @OneToOne()
    @JoinColumn(name = "contactdata_id")
    private Contactdata contactdata;

    @ManyToOne()
    @JoinColumn(name = "compmany_id")
    private Company company;
}
