package me.bvckslvsh.emarket.service;

import me.bvckslvsh.emarket.domain.Content;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContentService {

    void save(Content content);
    void edit(Long id, Content newContent);
    void delete(Long id);
    Content findById(Long id);

    List<Content> findAllByOrderId();
    List<Content> findAllByCategoryId(Long categoryId);

    Long count();
}
