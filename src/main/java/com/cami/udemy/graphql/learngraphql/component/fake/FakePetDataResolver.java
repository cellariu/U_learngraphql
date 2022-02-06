package com.cami.udemy.graphql.learngraphql.component.fake;

import com.cami.udemy.graphql.learngraphql.datasource.fake.FakePetsDatasource;
import com.cami.udemy.graphql.learngraphql.types.Pet;
import com.cami.udemy.graphql.learngraphql.types.PetFilter;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@DgsComponent
public class FakePetDataResolver {

    @DgsData(parentType = "Query", field = "pets")
    public List<Pet> pets(
            @InputArgument(name = "petFilter", collectionType = PetFilter.class) Optional<PetFilter> petFilter) {

        if (petFilter.isEmpty()) {
            return FakePetsDatasource.ALL_PETS;
        }

        return FakePetsDatasource.ALL_PETS.stream()
                .filter(pet -> match(petFilter.get(), pet))
                .collect(Collectors.toList());
    }

    private boolean match(PetFilter petFilter, Pet pet) {

        if (StringUtils.isNotBlank(petFilter.getPetType())) {
            if (!StringUtils.contains(petFilter.getPetType(), pet.getClass().getSimpleName())) {
                return false;
            }
        }

        return true;
    }
}
