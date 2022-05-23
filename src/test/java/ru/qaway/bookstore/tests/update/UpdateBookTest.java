package ru.qaway.bookstore.tests.update;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.BookData;
import ru.qaway.bookstore.tests.BookStoreTestBase;
import ru.qaway.bookstore.tests.rest.model.request.Book;

public class UpdateBookTest extends BookStoreTestBase {

    private Integer id;

    @BeforeClass
    public void setUp() {
        id = testClient.create(Book.defaultOf()).
                checkStatusCode(201).getId();
    }

    @Test(dataProvider = "positive", dataProviderClass = BookData.class)
    public void testUpdateBook(Book book) {
        testClient.update(id, book).
                checkStatusCode(200).
                checkId(id).
                checkLastUpdated().
                checkBook(book);

        testClient.read(id).
                checkStatusCode(200).
                checkId(id).
                checkLastUpdated().
                checkBook(book);
    }
}
