package com.cami.udemy.graphql.learngraphql.component.fake;

import com.cami.udemy.graphql.learngraphql.datasource.fake.FakeBookDatasource;
import com.cami.udemy.graphql.learngraphql.datasource.fake.FakeHelloDatasource;
import com.cami.udemy.graphql.learngraphql.types.SmartSearchResult;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;

@DgsComponent
public class FakeSmartSearchDataResolver {

    @DgsData(parentType = "Query", field = "smartSearch")
    public List<Object> smartSearch(
            @InputArgument(name = "keyword", collectionType = String.class) Optional<String> keyword) {

        SmartSearchResult.ALL_SEARCH_RESULTS.clear();

        if (keyword.isEmpty()) {
            SmartSearchResult.ALL_SEARCH_RESULTS.addAll(FakeHelloDatasource.HELLO_LIST);
            SmartSearchResult.ALL_SEARCH_RESULTS.addAll(FakeBookDatasource.BOOKS_LIST);
            return SmartSearchResult.ALL_SEARCH_RESULTS;
        }

        FakeHelloDatasource.HELLO_LIST.stream()
                .filter(h -> StringUtils.contains(h.getText(), keyword.get()))
                .forEach(SmartSearchResult::add);

        FakeBookDatasource.BOOKS_LIST.stream()
                .filter(b -> StringUtils.contains(b.getTitle(), keyword.get()))
                .forEach(SmartSearchResult::add);

        return SmartSearchResult.ALL_SEARCH_RESULTS;
    }

}
