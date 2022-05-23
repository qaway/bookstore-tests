package ru.qaway.bookstore.tests.rest.model.response;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;
import lombok.experimental.Accessors;
import ru.qaway.bookstore.tests.rest.model.request.BookExtended;

@Accessors(chain = true)
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse extends ErrorResponse {

    @JsonUnwrapped
    private BookExtended book;
}
