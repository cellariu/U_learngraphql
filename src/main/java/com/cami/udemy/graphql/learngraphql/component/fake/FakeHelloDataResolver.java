package com.cami.udemy.graphql.learngraphql.component.fake;

import com.cami.udemy.graphql.learngraphql.datasource.fake.FakeHelloDatasource;
import com.cami.udemy.graphql.learngraphql.types.Hello;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@DgsComponent
public class FakeHelloDataResolver {

    @DgsQuery
    public Hello oneHello() {
        return FakeHelloDatasource.HELLO_LIST.get(
                ThreadLocalRandom.current().nextInt(FakeHelloDatasource.HELLO_LIST.size()));
    }

    @DgsQuery
    public List<Hello> allHellos() {
        return FakeHelloDatasource.HELLO_LIST;
    }
}
