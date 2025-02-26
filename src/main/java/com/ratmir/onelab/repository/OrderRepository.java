package com.ratmir.onelab.repository;

import com.ratmir.onelab.dto.Book;
import com.ratmir.onelab.dto.Order;
import com.ratmir.onelab.dto.User;

import java.util.List;

public interface OrderRepository {
    List<Order> findAll();
    void createOrder(User user, Book book);
}
