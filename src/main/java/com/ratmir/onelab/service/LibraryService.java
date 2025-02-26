package com.ratmir.onelab.service;

import com.ratmir.onelab.dto.Book;
import com.ratmir.onelab.dto.Order;
import com.ratmir.onelab.dto.User;

import java.util.List;

public interface LibraryService {
    List<Book> listAllBooks();
    List<User> listAllUsers();
    void createOrder(Long userId, Long bookId);
    List<Order> listAllOrders();
}

