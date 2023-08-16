package com.tugceozcakir.paginationexample.database.repository;

import com.tugceozcakir.paginationexample.database.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
