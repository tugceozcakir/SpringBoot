package com.tugceozcakir.paginationexample.controller;

import com.tugceozcakir.paginationexample.model.BookDTO;
import com.tugceozcakir.paginationexample.model.PageDTO;
import com.tugceozcakir.paginationexample.model.requestDTO.BookRequestDTO;
import com.tugceozcakir.paginationexample.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public BookDTO create(@RequestBody BookRequestDTO bookRequestDTO){
        return bookService.save(bookRequestDTO);
    }

    @GetMapping
    public PageDTO<BookDTO> pagination(@RequestParam Integer pageSize,
                                       @RequestParam Integer page){

        return bookService.pagination(pageSize, page);
    }

}
