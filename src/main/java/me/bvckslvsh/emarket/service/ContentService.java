package me.bvckslvsh.emarket.service;

import me.bvckslvsh.emarket.domain.Content;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContentService {

    void save(Content content);
    void edit(long id, Content newContent);
    void delete(long id);
    Content findById(long id);

    List<Content> findAllByOrderId();
    List<Content> findAllByCategoryId(long categoryId);

    long count();
}
