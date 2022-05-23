package ru.qaway.bookstore.tests.rest.model.response;

import lombok.*;
import lombok.experimental.Accessors;
import ru.qaway.bookstore.tests.rest.model.request.BookExtended;

import java.util.List;

@Accessors(chain = true)
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BooksResponse extends ErrorResponse {

    private List<BookExtended> books;
    private Integer size;
}
