package com.yiqin.repository;

import com.yiqin.entity.Menu;

import java.util.List;

//@Repository
public interface MenuRepository{
    public Menu findById(long id);
}
