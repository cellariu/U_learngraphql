package com.cami.udemy.graphql.learngraphql.datasource.fake;

import com.cami.udemy.graphql.learngraphql.types.Cat;
import com.cami.udemy.graphql.learngraphql.types.Dog;
import com.cami.udemy.graphql.learngraphql.types.Pet;
import com.cami.udemy.graphql.learngraphql.types.PetFoodType;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class FakePetsDatasource {

    @Autowired
    private Faker faker;

    public static final List<Pet> ALL_PETS = new ArrayList<>();

    @PostConstruct
    private void postContruct() {
        for (int i = 0; i < 10; i++) {

            int petFoodTypeIdx = faker.random().nextInt(PetFoodType.values().length);

            var dog = Dog.builder()
                    .name(faker.dog().name())
                    .foodType(PetFoodType.values()[petFoodTypeIdx])
                    .breed(faker.dog().breed())
                    .size(faker.dog().size())
                    .coatLength(faker.dog().coatLength())
                    .build();


            var cat = Cat.builder()
                    .name(faker.cat().name())
                    .foodType(PetFoodType.values()[petFoodTypeIdx])
                    .breed(faker.cat().breed())
                    .registry(faker.cat().registry())
                    .build();

            int idxPet = i % 2;
            Pet pet = idxPet == 0 ? dog: cat;
            ALL_PETS.add(pet);
        }
    }
}
