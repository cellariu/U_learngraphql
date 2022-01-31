package com.cami.udemy.graphql.learngraphql.types;

import lombok.Builder;

import java.util.List;

@Builder
public class Author {

    private String name;
    private String originCountry;
    private List<Address> addresses;

    public Author(String name, String originCountry, List<Address> addresses) {
        this.name = name;
        this.originCountry = originCountry;
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
