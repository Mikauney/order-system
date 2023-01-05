package com.yiqin.repository;


import com.yiqin.entity.User;

import java.util.List;

public interface UserRepository {
    public User findById(long id);
}
