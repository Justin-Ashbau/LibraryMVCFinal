package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private final int maxBooks = 3;

    public Library() {
        this.books = new ArrayList<Book>();
        this.users = new ArrayList<User>();
    }

    public int findBookByName(String bookName) {
        int bookIndex = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(bookName)) bookIndex = i;
        }
        return bookIndex;
    }

    public int findUserByName(String userName) {
        int userIndex = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(userName)) userIndex = i;
        }
        return userIndex;
    }

    public String addBook(Book book) {
        int bookIndex = findBookByName(book.getName());
        if (bookIndex == -1) {
            books.add(book);
            return "Book added successfully";
        } else {
            return "Book already exists";
        }
    }

    public String removeBook(String bookName) {
        int bookIndex = findBookByName(bookName);
        if (bookIndex != -1) {
            String response = returnBook(bookName, books.get(bookIndex).getUser());
            books.remove(bookIndex);
            return "Book successfully removed";
        } else {
            return "Book does not exist";
        }
    }

    public String addUser(User user) {
        int userIndex = findUserByName(user.getName());
        if (userIndex == -1) {
            users.add(user);
            return "User added successfully";
        } else {
            return "User already exists";
        }
    }

    public String removeUser(String userName) {
        int userIndex = findUserByName(userName);
        if (userIndex != -1) {
            if (users.get(userIndex).getBookCount() > 0) {
                ArrayList<Book> userBooks = users.get(userIndex).getBooks();
                for (int i = 0; i < userBooks.size(); i++) {
                    String response = returnBook(userBooks.get(i).getName(), userName);
                }
            }
            users.remove(userIndex);
            return "User successfully removed";
        } else {
            return "User does not exist";
        }
    }

    public String checkOut(String bookName, String userName) {
        int bookIndex = findBookByName(bookName);
        int userIndex = findUserByName(userName);
        if (bookIndex != -1 && userIndex != -1) {
            if (books.get(bookIndex).getStatus().equals(Status.AVAILABLE)) {
                if (users.get(userIndex).getBookCount() < 3) {
                    books.get(bookIndex).setStatus(Status.CHECKED_OUT);
                    books.get(bookIndex).setUser(userName);
                    users.get(userIndex).addBook(books.get(bookIndex));
                    return "Book checked out successfully";
                } else {
                    return "User has too many books checked out";
                }
            } else {
                return "Book is alread checked out";
            }
        } else {
            return "Book or user does not exist";
        }
    }

    public String returnBook(String bookName, String userName) {
        int bookIndex = findBookByName(bookName);
        int userIndex = findUserByName(userName);
        if (bookIndex != -1 && userIndex != -1) {
            if (books.get(bookIndex).getUser().equals(userName)) {
                books.get(bookIndex).setStatus(Status.AVAILABLE);
                books.get(bookIndex).setUser("null");
                users.get(userIndex).removeBook(bookName);
                return "Book returned successfully";
            } else {
                return "User does not have that book checked out";
            }
        } else {
            return "Book or user does not exist";
        }
    }

    public String searchByUserName(String userName) {
        if (findUserByName(userName) == -1) {
            return "User does not exist";
        } else {
            String s = users.get(findUserByName(userName)).printUser() + "\n";
            if (users.get(findUserByName(userName)).getBookCount() > 0) {
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getUser().equals(userName)) {
                        s += books.get(i).printBook() + "\n";
                    }
                }
            }
            return s;
        }
    }

    public String searchByBookName(String bookName) {
        if (findBookByName(bookName) == -1) {
            return "Book does not exist";
        } else {
            return books.get(findBookByName(bookName)).printBook();
        }
    }

    public String searchByAuthor(String authorName) {
        String s = "";
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getAuthor().equals(authorName)) {
                s += books.get(i).printBook() + "\n";
            }
        }
        return s;
    }

    public String searchByPublisher(String publisherName) {
        String s = "";
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getPublisher().equals(publisherName)) {
                s += books.get(i).printBook() + "\n";
            }
        }
        return s;
    }
    public String sortByCreated() {
        String s = "";
        ArrayList<Book> sortedBooks = books;
        sortedBooks.sort(Comparator.comparing(Book::getDateCreated));
        for(int i = 0; i < sortedBooks.size(); i++) {
            s += books.get(i).printBook() + "\n";
        }
        return s;
    }
}
