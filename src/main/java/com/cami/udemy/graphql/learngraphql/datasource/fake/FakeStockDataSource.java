package com.cami.udemy.graphql.learngraphql.datasource.fake;

import com.cami.udemy.graphql.learngraphql.types.Stock;
import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.OffsetDateTime;

@Configuration
public class FakeStockDataSource {

    @Autowired
    private Faker faker;

    public Stock randomStock() {
        return Stock.builder()
                .symbol(faker.stock().nyseSymbol())
                .price(faker.random().nextInt(100, 1000))
                .lastTradeDateTime(OffsetDateTime.now())
                .build();
    }
}
