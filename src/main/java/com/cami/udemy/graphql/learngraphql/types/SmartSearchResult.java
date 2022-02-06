package com.cami.udemy.graphql.learngraphql.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SmartSearchResult {

    private String text;

    public static final List<Object> ALL_SEARCH_RESULTS = new ArrayList<>();

    public static void addAll(List<Object> specificSearchResults) {
        ALL_SEARCH_RESULTS.addAll(specificSearchResults);
    }

    public static void add(Object specificSearchResult) {
        ALL_SEARCH_RESULTS.add(specificSearchResult);
    }
}
