package com.cami.udemy.graphql.learngraphql.component.fake;

import com.cami.udemy.graphql.learngraphql.datasource.fake.FakeStockDataSource;
import com.cami.udemy.graphql.learngraphql.types.Stock;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsSubscription;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;

import java.time.Duration;

@DgsComponent
public class FakeStockDataResolver {

    @Autowired
    private FakeStockDataSource stockDatasource;

    @DgsSubscription
    public Publisher<Stock> randomStock() {
        return Flux.interval(Duration.ofSeconds(3))
                .map(s -> stockDatasource.randomStock());
    }
}
