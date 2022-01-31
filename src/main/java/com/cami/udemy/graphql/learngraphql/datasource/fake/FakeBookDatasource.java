package com.cami.udemy.graphql.learngraphql.datasource.fake;

import com.cami.udemy.graphql.learngraphql.types.Address;
import com.cami.udemy.graphql.learngraphql.types.Author;
import com.cami.udemy.graphql.learngraphql.types.Book;
import com.cami.udemy.graphql.learngraphql.types.ReleaseHistory;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class FakeBookDatasource {

    @Autowired
    private Faker faker;

    public static final List<Book> BOOKS_LIST = new ArrayList<>();

    @PostConstruct
    private void postContruct() {
        for (int i = 0; i < 20; i++) {
            List<Address> addresses = new ArrayList<>();

            for (int j = 0; j < ThreadLocalRandom.current().nextInt(1, 3); j++) {
                Address address = Address.builder()
                        .street(faker.address().streetAddress())
                        .city(faker.address().city())
                        .zipCode(faker.address().zipCode())
                        .country(faker.address().country())
                        .build();
                addresses.add(address);
            }

            var author = Author.builder()
                    .addresses(addresses)
                    .name(faker.book().author())
                    .originCountry(faker.country().name())
                    .build();

            var released = ReleaseHistory.builder()
                    .year(faker.number().numberBetween(2019, 2021))
                    .printedEdition(faker.bool().bool())
                    .releaseCountry(faker.country().name())
                    .build();

            var book = Book.builder()
                    .title(faker.book().title())
                    .publisher(faker.book().publisher())
                    .author(author)
                    .released(released)
                    .build();

            BOOKS_LIST.add(book);

        }

        System.out.println(BOOKS_LIST);
    }

}
