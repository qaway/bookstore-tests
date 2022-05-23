package ru.qaway.bookstore.tests.rest.model.response;

import io.restassured.response.Response;
import lombok.NoArgsConstructor;
import org.hamcrest.Matchers;
import org.testng.Assert;
import ru.qaway.bookstore.tests.rest.model.request.Book;

@NoArgsConstructor
public class CommonValidatableResponse<T extends CommonValidatableResponse> {

    protected Response response;

    public CommonValidatableResponse(Response response) {
        this.response = response;
    }

    public T checkStatusCode(int statusCode) {
        response.then().statusCode(statusCode);

        return (T)this;
    }

    public T checkErrorResponse(ErrorResponse expected) {
        response.then().body("timestamp", Matchers.notNullValue());
        Assert.assertEquals(new ErrorResponse(response.as(ErrorResponse.class)), expected);

        return (T)this;
    }
}
