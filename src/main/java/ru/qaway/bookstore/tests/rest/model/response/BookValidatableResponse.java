package ru.qaway.bookstore.tests.rest.model.response;

import io.restassured.response.Response;
import lombok.Getter;
import org.hamcrest.Matchers;
import org.testng.Assert;
import ru.qaway.bookstore.tests.rest.model.request.Book;

@Getter
public class BookValidatableResponse extends CommonValidatableResponse<BookValidatableResponse> {

    BookResponse model;

    public BookValidatableResponse(Response response) {
        super(response);
        if (response.asString().length() > 0) {
            model = response.as(BookResponse.class);
        }
    }

    public BookValidatableResponse checkIdNotNull() {
        response.then().body("id", Matchers.notNullValue());

        return this;
    }

    public BookValidatableResponse checkLastUpdated() {
        response.then().body("lastUpdated", Matchers.notNullValue());

        return this;
    }

    public BookValidatableResponse checkBook(Book expected) {
        Assert.assertEquals(new Book(model.getBook()), expected);

        return this;
    }

    public BookValidatableResponse checkId(Integer id) {
        response.then().body("id", Matchers.equalTo(id));

        return this;
    }

    public Integer getId() {
        return response.jsonPath().getInt("id");
    }
}
