package com.cami.udemy.graphql.learngraphql.types;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class MobileAppFilter {

    private String appId;
    private String name;
    private String version;
    private String platform;
    private AuthorFilter author;
    private LocalDate releasedAfter;
    private Integer minimumDownload;

    public MobileAppFilter() {
    }

    public MobileAppFilter(String appId, String name, String version, String platform,
                           AuthorFilter author, LocalDate releasedAfter, Integer minimumDownload) {
        this.appId = appId;
        this.name = name;
        this.version = version;
        this.platform = platform;
        this.author = author;
        this.releasedAfter = releasedAfter;
        this.minimumDownload = minimumDownload;
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

    public LocalDate getReleasedAfter() {
        return releasedAfter;
    }

    public void setReleasedAfter(LocalDate releasedAfter) {
        this.releasedAfter = releasedAfter;
    }

    public Integer getMinimumDownload() {
        return minimumDownload;
    }

    public void setMinimumDownload(Integer minimumDownload) {
        this.minimumDownload = minimumDownload;
    }
}
