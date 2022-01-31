package com.cami.udemy.graphql.learngraphql.types;

import lombok.Builder;

@Builder
public class Book {

    private String title;
    private String publisher;
    private Author author;
    private ReleaseHistory released;

    public Book(String title, String publisher, Author author, ReleaseHistory released) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.released = released;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public ReleaseHistory getReleased() {
        return released;
    }

    public void setReleased(ReleaseHistory released) {
        this.released = released;
    }
}
