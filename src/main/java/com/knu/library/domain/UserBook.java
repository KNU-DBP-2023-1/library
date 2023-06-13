package com.knu.library.domain;

import lombok.Data;
@Data

public class UserBook {
        private Long id;
        private String title;
        private String author;
        private String publisher;
        private String onRent;
        private String userid;

}
