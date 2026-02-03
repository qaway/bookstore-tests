package ru.qaway.bookstore.tests;

import org.testng.annotations.DataProvider;
import ru.qaway.bookstore.tests.rest.enums.Category;
import ru.qaway.bookstore.tests.rest.model.request.Book;

import static org.apache.commons.lang3.RandomStringUtils.secure;

public class BookData {

    @DataProvider
    public static Object[][] positive() {
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

    @DataProvider
    public static Object[][] negative() {
        return new Object[][] {
                { Book.defaultOf().setTitle(secure().nextAlphabetic(2))},
                { Book.defaultOf().setTitle(secure().nextAlphabetic(257))},
                { Book.defaultOf().setDescription(secure().nextAlphabetic(2))},
                { Book.defaultOf().setDescription(secure().nextAlphabetic(513))},
                { Book.defaultOf().setAuthor(secure().nextAlphabetic(2))},
                { Book.defaultOf().setAuthor(secure().nextAlphabetic(101))},
                { Book.defaultOf().setPrice(-1)},
                { Book.defaultOf().setCount(-1)},
                { Book.defaultOf().setCategory(Category.Unknown)},
        };
    }
}
