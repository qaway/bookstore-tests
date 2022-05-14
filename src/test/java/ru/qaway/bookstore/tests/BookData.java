package ru.qaway.bookstore.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import ru.qaway.bookstore.tests.rest.enums.Category;
import ru.qaway.bookstore.tests.rest.model.request.Book;

public class BookData {

    @DataProvider
    public static Object[][] positive() {
        return new Object[][] {
                { Book.defaultOf() },
                { Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(3)) },
                { Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(256)) },
                { Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(3)) },
                { Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(512)) },
                { Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(3)) },
                { Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(100)) },
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
                { Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(2))},
                { Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(257))},
                { Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(2))},
                { Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(513))},
                { Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(2))},
                { Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(101))},
                { Book.defaultOf().setPrice(-1)},
                { Book.defaultOf().setCount(-1)},
                { Book.defaultOf().setCategory(Category.Unknown)},
        };
    }
}
