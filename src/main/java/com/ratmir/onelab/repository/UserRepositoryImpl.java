package com.ratmir.onelab.repository;

import com.ratmir.onelab.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final List<User> users = new ArrayList<>();

    public UserRepositoryImpl() {
        User user1 = new User(1L, "John", "Doe", "john@example.com", 25, new ArrayList<>());
        User user2 = new User(2L, "Jane", "Smith", "jane@example.com", 30, new ArrayList<>());
        users.add(user1);
        users.add(user2);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
}
