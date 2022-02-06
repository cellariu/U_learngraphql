package com.cami.udemy.graphql.learngraphql.types;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HelloInput {

    private String text;
    private Integer number;
}
