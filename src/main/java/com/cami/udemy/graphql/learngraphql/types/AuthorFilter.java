package com.cami.udemy.graphql.learngraphql.types;

import lombok.Builder;

@Builder
public class AuthorFilter {
    private String name;

    public AuthorFilter() {
    }

    public AuthorFilter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
