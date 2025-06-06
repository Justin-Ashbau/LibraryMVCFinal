package view;

import java.awt.event.ActionListener;
import javax.swing.*;

public class LibraryView extends JFrame{
    private JLabel userLabel = new JLabel("User name");
    private JTextField userName = new JTextField(50);
    private JLabel bookLabel = new JLabel("Book name");
    private JTextField bookName = new JTextField(50);
    private JLabel authorLabel = new JLabel("Author name");
    private JTextField authorName = new JTextField(50);
    private JLabel publisherLabel = new JLabel("Publisher name");
    private JTextField publisherName = new JTextField(50);
    private JButton newUserButton = new JButton("Create new user");
    private JButton newBookButton = new JButton("Create new book");
    private JButton removeUserButton = new JButton("Remove user");
    private JButton removeBookButton = new JButton("Remove book");
    private JButton checkoutButton = new JButton("Checkout book");
    private JButton returnButton = new JButton("Return book");
    private JTextField searchField = new JTextField(60);
    private JButton searchUserButton = new JButton("Search user");
    private JButton searchBookButton = new JButton("Search book");
    private JButton searchAuthorButton = new JButton("Search author");
    private JButton searchPublisherButton = new JButton("Search publisher");
    private JTextArea responseArea = new JTextArea(12, 50);


    public LibraryView() {
        JPanel libPanel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650, 500);

        libPanel.add(userName);
        libPanel.add(userLabel);
        libPanel.add(bookName);
        libPanel.add(bookLabel);
        libPanel.add(authorName);
        libPanel.add(authorLabel);
        libPanel.add(publisherName);
        libPanel.add(publisherLabel);
        libPanel.add(newUserButton);
        libPanel.add(newBookButton);
        libPanel.add(removeUserButton);
        libPanel.add(removeBookButton);
        libPanel.add(checkoutButton);
        libPanel.add(returnButton);
        libPanel.add(searchField);
        libPanel.add(searchUserButton);
        libPanel.add(searchBookButton);
        libPanel.add(searchAuthorButton);
        libPanel.add(searchPublisherButton);
        libPanel.add(new JScrollPane(responseArea));

        this.add(libPanel);
    }

    public String getUserName() {
        return userName.getText();
    }
    public String getBookName() {
        return bookName.getText();
    }
    public String getAuthorName() {
        return authorName.getText();
    }
    public String getPublisherName() {
        return publisherName.getText();
    }
    public String getQuery() {
        return searchField.getText();
    }
    public void setResponse(String s) {
        responseArea.setText(s);
    }

    public void addNewUserListener(ActionListener listenForNewUserButton) {
        newUserButton.addActionListener(listenForNewUserButton);
    }
    public void addNewBookListener(ActionListener listenForNewBookButton) {
        newBookButton.addActionListener(listenForNewBookButton);
    }
    public void removeUserListener(ActionListener listenForRemoveUserButton) {
        removeUserButton.addActionListener(listenForRemoveUserButton);
    }
    public void removeBookListener(ActionListener listenForRemoveBookButton) {
        removeBookButton.addActionListener(listenForRemoveBookButton);
    }
    public void checkoutListener(ActionListener listenForCheckoutButton) {
        checkoutButton.addActionListener(listenForCheckoutButton);
    }
    public void returnListener(ActionListener listenForReturnButton) {
        returnButton.addActionListener(listenForReturnButton);
    }
    public void searchUserListener(ActionListener listenForSearchUserButton) {
        searchUserButton.addActionListener(listenForSearchUserButton);
    }
    public void searchBookListener(ActionListener listenForSearchBookButton) {
        searchBookButton.addActionListener(listenForSearchBookButton);
    }
    public void searchAuthorListener(ActionListener listenForSearchAuthorButton) {
        searchAuthorButton.addActionListener(listenForSearchAuthorButton);
    }
    public void searchPublisherListener(ActionListener listenForSearchPublisherButton) {
        searchPublisherButton.addActionListener(listenForSearchPublisherButton);
    }
}
