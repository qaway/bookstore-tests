package ru.qaway.bookstore.tests.rest.model.response;

import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.Assert;
import ru.qaway.bookstore.tests.rest.model.request.BookExtended;

import java.util.List;

public class BooksValidatableResponse extends CommonValidatableResponse<BooksValidatableResponse> {

    BooksResponse model;

    public BooksValidatableResponse(Response response) {
        super(response);
        if (response.asString().length() > 0) {
            model = response.as(BooksResponse.class);
        }
    }

    public BooksValidatableResponse checkBooks(Integer expectedSize, List<BookExtended> expected) {
        Assert.assertEquals(model.getSize(), expectedSize);
        MatcherAssert.assertThat(model.getBooks(), Matchers.containsInAnyOrder(expected.toArray()));

        return this;
    }
}
