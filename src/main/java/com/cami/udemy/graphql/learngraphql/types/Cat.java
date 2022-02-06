package com.cami.udemy.graphql.learngraphql.types;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cat implements Pet {
    private String name;
    private PetFoodType foodType;
    private String breed;
    private String registry;
}
