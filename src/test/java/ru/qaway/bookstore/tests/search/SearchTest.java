package ru.qaway.bookstore.tests.search;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.BookStoreTestBase;
import ru.qaway.bookstore.tests.rest.model.request.Book;
import ru.qaway.bookstore.tests.rest.model.request.BookExtended;
import ru.qaway.bookstore.tests.rest.model.request.Search;

import java.util.ArrayList;
import java.util.List;

public class SearchTest extends BookStoreTestBase {

    private List<BookExtended> books;

    @BeforeClass
    public void setUp() {
        testClient.delete();
        books = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            books.add(testClient.create(Book.defaultOf()).
                    checkStatusCode(201).getModel().getBook());
        }
    }

    @Test
    public void testCreateBook() {
        testClient.read(Search.of()).
                checkStatusCode(200).
                checkBooks(books.size(), books);

    }
}
