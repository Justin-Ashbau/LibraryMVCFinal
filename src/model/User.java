package model;

import java.util.ArrayList;

public class User {
    public String name;
    public int bookCount;
    public ArrayList<Book> userBooks;

    //Constructor
    public User(String name) {
        this.name = name;
        this.bookCount = 0;
        this.userBooks = new ArrayList<Book>();
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void addBook(Book book) {
        userBooks.add(book);
        bookCount++;
    }
    public void removeBook(String bookName) {
        for(int i = 0; i < userBooks.size(); i++) {
            if(userBooks.get(i).getName().equals(bookName)) {
                userBooks.remove(i);
                bookCount--;
                return;
            }
        }
    }
    public void removeAll() {
        userBooks.removeAll(userBooks);
    }

    //Getters
    public String getName() {
        return name;
    }
    public int getBookCount() {
        return bookCount;
    }
    public ArrayList<Book> getBooks() {
        return userBooks;
    }

    //Ouput
    public String printUser() {
        String s = "Name: " + name + "\n";
        s += "Number of Books Checked Out: " + bookCount + "\n";
        return s;
    }
}
