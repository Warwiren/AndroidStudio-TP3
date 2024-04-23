package Model;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private static BookManager instance;
    private List<Book> bookList;

    private BookManager() {
        bookList = new ArrayList<>();
        bookList.add(new Book("Silmarillon", 2));
        bookList.add(new Book("Autre Monde", 3));
        bookList.add(new Book("Livre 3", 1));
        bookList.add(new Book("Silmarillon", 2));
        bookList.add(new Book("Autre Monde", 3));
        bookList.add(new Book("Livre 3", 1));
        bookList.add(new Book("Silmarillon", 2));
        bookList.add(new Book("Autre Monde", 3));
        bookList.add(new Book("Livre 3", 1));
    }

    public static synchronized BookManager getInstance() {
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }
}