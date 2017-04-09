package ru.bmstu.rk.rest;

import org.springframework.hateoas.ResourceSupport;

public class BookResource extends ResourceSupport {

    private String name;
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
