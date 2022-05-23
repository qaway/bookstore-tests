package ru.qaway.bookstore.tests.create;

import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.BookData;
import ru.qaway.bookstore.tests.BookStoreTestBase;
import ru.qaway.bookstore.tests.rest.model.request.Book;
import ru.qaway.bookstore.tests.rest.model.response.ErrorResponse;

public class CreateBookNegativeTest extends BookStoreTestBase {

    @Test(dataProvider = "negative", dataProviderClass = BookData.class)
    public void testCreate(Book book) {
        testClient.create(book).
                checkStatusCode(400).
                checkErrorResponse(ErrorResponse.createError400());
    }
}
