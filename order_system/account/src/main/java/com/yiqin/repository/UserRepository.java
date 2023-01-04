package com.yiqin.repository;

import com.yiqin.entity.User;

public interface UserRepository {
    public User login(String username, String password);
}
