package com.tugceozcakir.paginationexample.model.requestDTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookRequestDTO {
    private String isbn;
    private String title;
    private String author;
    private LocalDate publishDate;
}
