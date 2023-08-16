package com.tugceozcakir.paginationexample.util;

import com.tugceozcakir.paginationexample.database.entity.BookEntity;
import com.tugceozcakir.paginationexample.model.BookDTO;
import com.tugceozcakir.paginationexample.model.requestDTO.BookRequestDTO;

import java.util.List;

public interface IBookMapper {
    BookDTO entityTODto(BookEntity bookEntity);
    BookEntity dtoToEntity(BookDTO bookDTO);
    BookEntity requestDtoToEntity(BookRequestDTO bookRequestDTO);
    List<BookDTO> entityListToDTOList(List<BookEntity> entityList);
}
