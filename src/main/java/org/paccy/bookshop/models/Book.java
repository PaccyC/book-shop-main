package org.paccy.bookshop.models;

public class Book {

    private String id;
    private String name;
    private String author;
    private int year_of_publication;
    private String category;

    public Book(int id, String name, String author, int year_of_publication, String category) {
        this.id= String.valueOf(id);
        this.name = name;
        this.author = author;
        this.year_of_publication = year_of_publication;
        this.category = category;
    }

    public Book( String name, String author, int year_of_publication, String category) {
        this.name = name;
        this.author = author;
        this.year_of_publication = year_of_publication;
        this.category = category;
    }

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

    public int getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(int year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
