import controller.LibraryController;
import model.Library;
import view.LibraryView;

public class LibraryApp {
    public static void main(String[] args){

        LibraryView libraryView = new LibraryView();
        Library library = new Library();
        LibraryController libraryController = new LibraryController(library, libraryView);
        libraryView.setVisible(true);

    }
}
