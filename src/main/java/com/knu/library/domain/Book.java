package com.knu.library.domain;

import lombok.Data;

public class Book {
    @Data
    public static class Create {
        private String title;
        private String author;
        private String publisher;
        private String onRent;
    }

    @Data
    public static class Update {
        private String title;
        private String author;
        private String publisher;
        private String onRent;
    }

    @Data
    public static class Simple {
        private Long id;
        private String title;
        private String author;
        private String publisher;
        private String onRent;
    }
}