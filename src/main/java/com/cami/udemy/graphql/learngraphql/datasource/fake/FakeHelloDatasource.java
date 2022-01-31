package com.cami.udemy.graphql.learngraphql.datasource.fake;

import com.cami.udemy.graphql.learngraphql.types.Hello;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class FakeHelloDatasource {

    @Autowired
    private Faker faker;

    public static final List<Hello> HELLO_LIST = new ArrayList<>();

    @PostConstruct
    private void postContruct() {
        for (int i = 0; i < 20; i++) {
            var hello = Hello.builder()
                    .randomNumber(faker.random().nextInt(5000))
                    .text(faker.country().name())
                    .build();
            HELLO_LIST.add(hello);
        }
    }
}
