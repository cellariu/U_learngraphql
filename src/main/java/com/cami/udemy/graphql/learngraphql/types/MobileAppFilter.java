package com.cami.udemy.graphql.learngraphql.types;

import lombok.Builder;

@Builder
public class MobileAppFilter {

    private String appId;
    private String name;
    private String version;
    private String platform;
    private AuthorFilter author;

    public MobileAppFilter() {
    }

    public MobileAppFilter(String appId, String name, String version, String platform, AuthorFilter author) {
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
