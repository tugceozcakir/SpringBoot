package com.tugceozcakir.paginationexample.api;

import com.tugceozcakir.paginationexample.database.entity.BookEntity;
import com.tugceozcakir.paginationexample.database.repository.BookRepository;
import com.tugceozcakir.paginationexample.model.BookDTO;
import com.tugceozcakir.paginationexample.model.PageDTO;
import com.tugceozcakir.paginationexample.model.requestDTO.BookRequestDTO;
import com.tugceozcakir.paginationexample.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
