package com.cami.udemy.graphql.learngraphql.types;

public class ReleaseHistoryInput {

    private Integer year;
    private Boolean printedEdition;

    public ReleaseHistoryInput() {
    }

    public ReleaseHistoryInput(Integer year, Boolean printedEdition) {
        this.year = year;
        this.printedEdition = printedEdition;
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
}
