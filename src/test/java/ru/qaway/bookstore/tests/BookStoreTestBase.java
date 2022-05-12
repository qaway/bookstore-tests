package ru.qaway.bookstore.tests;

import ru.qaway.bookstore.tests.rest.client.TestClient;

public class BookStoreTestBase {

    protected static TestClient testClient;

    static {
        testClient = new TestClient();;
    }
}
