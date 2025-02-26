package com.ratmir.onelab.repository;

import com.ratmir.onelab.dto.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final List<Book> books = new ArrayList<>();

    public BookRepositoryImpl() {
        books.add(new Book(1L, "Book 1", "Author A", "Publisher X", "1234567890", null));
        books.add(new Book(2L, "Book 2", "Author B", "Publisher Y", "0987654321", null));
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }
}
