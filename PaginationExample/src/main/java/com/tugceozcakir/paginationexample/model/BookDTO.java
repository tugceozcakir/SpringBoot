package com.tugceozcakir.paginationexample.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDTO {
    private String isbn;
    private String title;
    private String author;
    private LocalDate publishDate;
}
