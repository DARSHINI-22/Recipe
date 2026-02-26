package com.example.recipes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Embeddable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nutrients {

    private String calories;
    private String fatContent;
    private String carbohydrateContent;
    private String proteinContent;
    private String cholesterolContent;
    private String sodiumContent;
}