package ru.qaway.bookstore.tests.rest.model.request;

import lombok.*;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;

@Accessors(chain = true)
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BookExtended extends Book {

    private Integer id;
    private OffsetDateTime lastUpdated;
}
