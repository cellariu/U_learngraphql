package com.cami.udemy.graphql.learngraphql.types;

import lombok.Builder;

import java.util.List;

@Builder
public class MobileApp {

    private String appId;
    private String name;
    private String version;
    private List<String> platform;
    private Author author;

    public MobileApp() {
    }

    public MobileApp(String appId, String name, String version, List<String> platform, Author author) {
        this.appId = appId;
        this.name = name;
        this.version = version;
        this.platform = platform;
        this.author = author;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
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

    public List<String> getPlatform() {
        return platform;
    }

    public void setPlatform(List<String> platform) {
        this.platform = platform;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
