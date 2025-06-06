package controller;

import model.Book;
import model.Library;
import model.User;
import view.LibraryView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryController {
    private Library library;
    private LibraryView libraryView;

    public LibraryController(Library library, LibraryView libraryView) {
        this.library = library;
        this.libraryView = libraryView;

        this.libraryView.addNewUserListener(new NewUserButtonListener());
        this.libraryView.addNewBookListener(new NewBookButtonListener());
        this.libraryView.removeUserListener(new RemoveUserButtonListener());
        this.libraryView.removeBookListener(new RemoveBookButtonListener());
        this.libraryView.checkoutListener(new CheckoutButtonListener());
        this.libraryView.returnListener(new RetrunButtonListener());
        this.libraryView.searchUserListener(new SearchUserButtonListener());
        this.libraryView.searchBookListener(new SearchBookButtonListener());
        this.libraryView.searchAuthorListener(new SearchAuthorButtonListener());
        this.libraryView.searchPublisherListener(new SearchPublisherListener());
    }

    class NewUserButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            User user  = new User(libraryView.getUserName());
            libraryView.setResponse(library.addUser(user));
        }
    }
    class NewBookButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Book book = new Book(libraryView.getBookName(), libraryView.getAuthorName(), libraryView.getPublisherName());
            libraryView.setResponse(library.addBook(book));
        }
    }
    class RemoveUserButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String userName = libraryView.getUserName();
            libraryView.setResponse(library.removeUser(userName));
        }
    }
    class RemoveBookButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String bookName = libraryView.getBookName();
            libraryView.setResponse(library.removeBook(bookName));
        }
    }
    class CheckoutButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String bookName = libraryView.getBookName();
            String userName = libraryView.getUserName();
            libraryView.setResponse(library.checkOut(bookName, userName));
        }
    }
    class RetrunButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String bookName = libraryView.getBookName();
            String userName = libraryView.getUserName();
            libraryView.setResponse(library.returnBook(bookName, userName));
        }
    }
    class SearchUserButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            libraryView.setResponse(library.searchByUserName(libraryView.getQuery()));
        }
    }
    class SearchBookButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            libraryView.setResponse(library.searchByBookName(libraryView.getQuery()));
        }
    }
    class SearchAuthorButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            libraryView.setResponse(library.searchByAuthor(libraryView.getQuery()));
        }
    }
    class SearchPublisherListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            libraryView.setResponse(library.searchByPublisher(libraryView.getQuery()));
        }
    }
}
