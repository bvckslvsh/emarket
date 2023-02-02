package me.bvckslvsh.emarket.repository;

import me.bvckslvsh.emarket.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByTitle(String name);
}
