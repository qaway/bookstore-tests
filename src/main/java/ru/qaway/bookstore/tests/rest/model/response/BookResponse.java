package ru.qaway.bookstore.tests.rest.model.response;

import lombok.*;
import lombok.experimental.Accessors;
import ru.qaway.bookstore.tests.rest.model.request.Book;

import java.time.OffsetDateTime;

@Accessors(chain = true)
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse extends Book {

    private Integer id;
    private OffsetDateTime lastUpdated;

    @EqualsAndHashCode.Exclude
    private OffsetDateTime timestamp;
    private Integer status;
    private String error;
    private String path;

    public static BookResponse createError400() {
        return new BookResponse().setStatus(400).
                setError("Bad Request").
                setPath("/rest-api/books");
    }
}
