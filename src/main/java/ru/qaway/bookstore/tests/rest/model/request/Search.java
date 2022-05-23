package ru.qaway.bookstore.tests.rest.model.request;

import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(staticName = "of")
public class Search {
    Map<String, Object> params;

    public Search queryParam(String name, Object value) {
        params.put(name, value);

        return this;
    }

    public Map<String, Object> get() {
        return params;
    }
}
