package model;

import java.time.LocalDate;

public class Book {
    private String name;
    private String author;
    private String publisher;
    private Status status;
    private String user;
    private LocalDate dateCreated;

    //Constructor
    public Book(String name, String author, String publisher) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.status = Status.AVAILABLE;
        this.user = "null";
        this.dateCreated = LocalDate.now();
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setUser(String user) {
        this.user = user;
    }

    //Getters
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }
    public Status getStatus() {
        return status;
    }
    public String getUser() {
        return user;
    }

    //Output
    public String printBook() {
        String s = "Name: " + name + "\n";
        s += "Author: " + author + "\n";
        s += "Publisher: " + publisher + "\n";
        s += "User: " + user + "\n";
        return s;
    }
}
