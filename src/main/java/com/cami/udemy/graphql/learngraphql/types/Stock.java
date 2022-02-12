package com.cami.udemy.graphql.learngraphql.types;

import graphql.scalars.numeric.NonNegativeIntScalar;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stock {

    private String symbol;
    private Integer price;
    private OffsetDateTime lastTradeDateTime;
}
