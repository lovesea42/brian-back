package com.brianxia.brian.DoubanBook.entity;

public class DoubanBook {

    private String name;
    private String author;
    private String publisher;
    private Float star;
    private Float price;

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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Float getStar() {
        return star;
    }

    public void setStar(Float star) {
        this.star = star;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
