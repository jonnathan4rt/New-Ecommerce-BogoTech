package com.newpiece.application.repository;

import com.newpiece.domain.User;

public interface UserRepository {
    public User createUser(User user);
    public User findByEmail(String email);
    public User findById(Integer id);
}
