package com.cami.udemy.graphql.learngraphql.types;

import lombok.Builder;

@Builder
public class MobileAppFilter {

    private String name;
    private String version;
    private String platform;
    private AuthorFilter author;

    public MobileAppFilter() {
    }

    public MobileAppFilter(String name, String version, String platform, AuthorFilter author) {
        this.name = name;
        this.version = version;
        this.platform = platform;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public AuthorFilter getAuthor() {
        return author;
    }

    public void setAuthor(AuthorFilter author) {
        this.author = author;
    }
}
