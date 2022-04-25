package ru.qaway.bookstore.tests.rest.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.qaway.bookstore.tests.rest.enums.Category;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String title;
    private String description;
    private String author;
    private Integer price;
    private Integer count;
    private Category category;
}
