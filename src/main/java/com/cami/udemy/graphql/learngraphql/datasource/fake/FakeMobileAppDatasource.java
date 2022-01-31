package com.cami.udemy.graphql.learngraphql.datasource.fake;

import com.cami.udemy.graphql.learngraphql.types.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class FakeMobileAppDatasource {

    @Autowired
    private Faker faker;

    public static final List<MobileApp> MOBILE_APPS = new ArrayList<>();

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

            List<String> platforms = randomMobileAppPlatform();

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

            var mobileApp = MobileApp.builder()
                    .name(faker.app().name())
                    .version(faker.app().version())
                    .platform(platforms)
                    .author(author)
                    .build();

            MOBILE_APPS.add(mobileApp);

        }

        System.out.println(MOBILE_APPS);
    }

    private List<String> randomMobileAppPlatform() {
        switch(ThreadLocalRandom.current().nextInt(10) % 3) {
            case 0:
                return List.of("android");
            case 1:
                return List.of("ios");
            case 2:
                return List.of("ios", "android");
            default: return List.of("ios", "android");
        }
    }

}
