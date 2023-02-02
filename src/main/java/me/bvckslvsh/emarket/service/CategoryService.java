package me.bvckslvsh.emarket.service;

import me.bvckslvsh.emarket.domain.Category;

import java.util.List;

public interface CategoryService {

    void save(Category category);
    List<Category> findAll();
}
