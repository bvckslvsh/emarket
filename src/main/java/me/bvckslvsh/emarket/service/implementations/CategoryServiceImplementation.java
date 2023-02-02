package me.bvckslvsh.emarket.service.implementations;

import me.bvckslvsh.emarket.domain.Category;
import me.bvckslvsh.emarket.repository.CategoryRepository;
import me.bvckslvsh.emarket.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImplementation(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
