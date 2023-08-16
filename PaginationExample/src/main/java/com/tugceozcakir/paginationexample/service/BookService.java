package com.tugceozcakir.paginationexample.service;

import com.tugceozcakir.paginationexample.database.entity.BookEntity;
import com.tugceozcakir.paginationexample.database.repository.BookRepository;
import com.tugceozcakir.paginationexample.mapper.BookMapper;
import com.tugceozcakir.paginationexample.model.BookDTO;
import com.tugceozcakir.paginationexample.model.PageDTO;
import com.tugceozcakir.paginationexample.model.requestDTO.BookRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    BookRepository bookRepository;

    public BookDTO save(@RequestBody BookRequestDTO bookRequestDTO){
        BookEntity bookEntity = bookMapper.requestDtoToEntity(bookRequestDTO);
        bookRepository.save(bookEntity);
        return bookMapper.entityTODto(bookEntity);
    }
    public PageDTO<BookDTO> pagination(@RequestParam Integer pageSize,
                                       @RequestParam Integer page) {

        Pageable pageable = PageRequest.of(page, pageSize);
        Page<BookEntity> bookEntityPage = bookRepository.findAll(pageable);

        PageDTO<BookDTO> bookDTOS = bookMapper.pageEntityToPageDTO(bookEntityPage);

        return bookDTOS;
    }
}
