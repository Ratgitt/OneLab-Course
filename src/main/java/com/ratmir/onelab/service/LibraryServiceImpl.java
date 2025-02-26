package com.ratmir.onelab.service;

import com.ratmir.onelab.dto.Book;
import com.ratmir.onelab.dto.Order;
import com.ratmir.onelab.dto.User;
import com.ratmir.onelab.repository.BookRepository;
import com.ratmir.onelab.repository.OrderRepository;
import com.ratmir.onelab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public LibraryServiceImpl(UserRepository userRepository, BookRepository bookRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createOrder(Long userId, Long bookId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Book> book = bookRepository.findById(bookId);

        if (user.isPresent() && book.isPresent() && book.get().getOwner() == null) {
            orderRepository.createOrder(user.get(), book.get());
        } else {
            throw new IllegalStateException("Ошибка создания заказа: неверный пользователь или книга уже занята.");
        }
    }

    @Override
    public List<Order> listAllOrders() {
        return orderRepository.findAll();
    }
}