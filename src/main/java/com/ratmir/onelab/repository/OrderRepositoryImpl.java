package com.ratmir.onelab.repository;

import com.ratmir.onelab.dto.Book;
import com.ratmir.onelab.dto.Order;
import com.ratmir.onelab.dto.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> findAll() {
        return orders;
    }

    @Override
    public void createOrder(User user, Book book) {
        Order order = new Order((long) (orders.size() + 1), user, book, LocalDateTime.now());
        orders.add(order);
        user.addBook(book);
    }
}