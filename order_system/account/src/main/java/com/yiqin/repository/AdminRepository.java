package com.yiqin.repository;

import com.yiqin.entity.Admin;

public interface AdminRepository {
    public Admin login(String unsername, String password);
}
