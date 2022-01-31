package com.cami.udemy.graphql.learngraphql.types;

import lombok.Builder;

@Builder
public class ReleaseHistory {

    private Integer year;
    private Boolean printedEdition;
    private String releaseCountry;

    public ReleaseHistory(Integer year, Boolean printedEdition, String releaseCountry) {
        this.year = year;
        this.printedEdition = printedEdition;
        this.releaseCountry = releaseCountry;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getPrintedEdition() {
        return printedEdition;
    }

    public void setPrintedEdition(Boolean printedEdition) {
        this.printedEdition = printedEdition;
    }

    public String getReleaseCountry() {
        return releaseCountry;
    }

    public void setReleaseCountry(String releaseCountry) {
        this.releaseCountry = releaseCountry;
    }
}
