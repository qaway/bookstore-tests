package ru.qaway.bookstore.tests.rest.model.response;

import lombok.*;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;

@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    @EqualsAndHashCode.Exclude
    private OffsetDateTime timestamp;
    private Integer status;
    private String error;
    private String path;

    public ErrorResponse(ErrorResponse response) {
        this.setStatus(response.getStatus()).
                setError(response.getError()).
                setPath(response.getPath());
    }

    private static ErrorResponse error400() {
        return new ErrorResponse().setStatus(400).
                setError("Bad Request");
    }

    public static ErrorResponse createError400() {
        return error400().
                setPath("/rest-api/books");
    }

    public static ErrorResponse updateError400(Integer id) {
        return error400().
                setPath(String.format("/rest-api/books/%s", id));
    }
}
