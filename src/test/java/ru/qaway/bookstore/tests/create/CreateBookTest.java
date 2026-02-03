package ru.qaway.bookstore.tests.create;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.rest.client.TestClient;
import ru.qaway.bookstore.tests.rest.enums.Category;
import ru.qaway.bookstore.tests.rest.model.request.Book;
import ru.qaway.bookstore.tests.rest.model.response.BookValidatableResponse;

import static org.apache.commons.lang3.RandomStringUtils.secure;

public class CreateBookTest {

    @Test(dataProvider = "createBooks")
    public void testCreateBook(Book book) {
        TestClient client = new TestClient();

        BookValidatableResponse response = client.create(book).
                checkStatusCode(201).
                checkIdNotNull().
                checkLastUpdated().
                checkBook(book);

        client.read(response.getId()).
                checkStatusCode(200).
                checkId(response.getId()).
                checkLastUpdated().
                checkBook(book);

    }

    @DataProvider
    public Object[][] createBooks() {
        return new Object[][] {
                { Book.defaultOf() },
                { Book.defaultOf().setTitle(secure().nextAlphabetic(3)) },
                { Book.defaultOf().setTitle(secure().nextAlphabetic(256)) },
                { Book.defaultOf().setDescription(secure().nextAlphabetic(3)) },
                { Book.defaultOf().setDescription(secure().nextAlphabetic(512)) },
                { Book.defaultOf().setAuthor(secure().nextAlphabetic(3)) },
                { Book.defaultOf().setAuthor(secure().nextAlphabetic(100)) },
                { Book.defaultOf().setPrice(0) },
                { Book.defaultOf().setCount(0) },
                { Book.defaultOf().setCategory(Category.Detective) },
                { Book.defaultOf().setCategory(Category.Fiction) },
                { Book.defaultOf().setCategory(Category.Horror) },
                { Book.defaultOf().setCategory(Category.Thriller) },
        };
    }
}
