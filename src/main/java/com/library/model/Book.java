package com.library.model;

public class Book {
    private String title;
    private String author;
    private int year;
    private boolean available;
    private int id;
    public Book(int id, String title, String author, int year, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
    }
    public boolean isAvailable() {
        return available;
    }
    public int getYear() {
        return year;
    }
    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", available=" + available +
                ", id=" + id +
                '}';
    }





}
