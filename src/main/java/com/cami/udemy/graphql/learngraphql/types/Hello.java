package com.cami.udemy.graphql.learngraphql.types;

import lombok.Builder;

@Builder
public class Hello {

    private String text;
    private Integer randomNumber;

    public Hello(String text, Integer randomNumber) {
        this.text = text;
        this.randomNumber = randomNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Integer randomNumber) {
        this.randomNumber = randomNumber;
    }
}
