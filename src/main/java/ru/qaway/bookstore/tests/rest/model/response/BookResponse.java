package ru.qaway.bookstore.tests.rest.model.response;

import lombok.*;
import ru.qaway.bookstore.tests.rest.enums.Category;
import ru.qaway.bookstore.tests.rest.model.request.Book;

import java.time.OffsetDateTime;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse extends Book {

    private Integer id;
    private OffsetDateTime lastUpdated;
}
