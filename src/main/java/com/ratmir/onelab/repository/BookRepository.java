package com.ratmir.onelab.repository;

import com.ratmir.onelab.dto.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();
    Optional<Book> findById(Long id);
}
