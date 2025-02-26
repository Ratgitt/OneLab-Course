package com.ratmir.onelab.repository;

import com.ratmir.onelab.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();
    Optional<User> findById(Long id);
}
