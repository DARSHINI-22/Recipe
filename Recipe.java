package com.example.recipes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String cuisine;

    private Double rating;

    private Integer prepTime;

    private Integer cookTime;

    private Integer totalTime;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    private String serves;

    @Embedded
    private Nutrients nutrients;
}