package com.tugceozcakir.paginationexample.mapper;

import com.tugceozcakir.paginationexample.database.entity.BookEntity;
import com.tugceozcakir.paginationexample.model.BookDTO;
import com.tugceozcakir.paginationexample.model.PageDTO;
import com.tugceozcakir.paginationexample.model.requestDTO.BookRequestDTO;
import com.tugceozcakir.paginationexample.util.IBookMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper implements IBookMapper {
    @Override
    public BookDTO entityTODto(BookEntity bookEntity) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthor(bookEntity.getAuthor());
        bookDTO.setIsbn(bookEntity.getIsbn());
        bookDTO.setTitle(bookEntity.getTitle());
        bookDTO.setPublishDate(bookEntity.getPublishDate());
        return bookDTO;
    }

    @Override
    public BookEntity dtoToEntity(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthor(bookDTO.getAuthor());
        bookEntity.setIsbn(bookDTO.getIsbn());
        bookEntity.setTitle(bookDTO.getTitle());
        bookEntity.setPublishDate(bookDTO.getPublishDate());
        return bookEntity;
    }

    @Override
    public BookEntity requestDtoToEntity(BookRequestDTO bookRequestDTO) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthor(bookRequestDTO.getAuthor());
        bookEntity.setIsbn(bookRequestDTO.getIsbn());
        bookEntity.setTitle(bookRequestDTO.getTitle());
        bookEntity.setPublishDate(bookRequestDTO.getPublishDate());
        return bookEntity;
    }

    @Override
    public List<BookDTO> entityListToDTOList(List<BookEntity> entityList) {
        List<BookDTO> bookDTOList = new ArrayList<>();

        for (BookEntity bookEntity : entityList) {
            bookDTOList.add(entityTODto(bookEntity));
        }
        return bookDTOList;
    }
    
    public PageDTO<BookDTO> pageEntityToPageDTO(Page<BookEntity> entityPage) {
        List<BookDTO> dtoList = entityPage.getContent().stream()
                .map(this::entityTODto)
                .collect(Collectors.toList());

        return new PageDTO<>(dtoList, entityPage.getTotalElements());
    }

}