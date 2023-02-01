package me.bvckslvsh.emarket.service.implementations;

import me.bvckslvsh.emarket.domain.Content;
import me.bvckslvsh.emarket.repository.ContentRepository;
import me.bvckslvsh.emarket.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImplementation implements ContentService {
    private final ContentRepository contentRepository;

    @Autowired
    public ContentServiceImplementation(ContentRepository contentRepository){
        this.contentRepository = contentRepository;
    }


    @Override
    public void save(Content content) {
        contentRepository.save(content);
    }

    @Override
    public void edit(long id, Content newContent) {
        Content found = contentRepository.getOne(id);
        found.setTitle(newContent.getTitle());
        found.setImageurl(newContent.getImageurl());
        found.setDescription(newContent.getDescription());
        found.setPrice(newContent.getPrice());
        save(newContent);
    }

    @Override
    public void delete(long id) {
        contentRepository.delete(findById(id));
    }

    @Override
    public Content findById(long id) {
        return contentRepository.findById(id);
    }

    @Override
    public List<Content> findAllByOrderId() {
        return contentRepository.findAllByOrderById();
    }

    @Override
    public List<Content> findAllByCategoryId(long categoryId) {
        return contentRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public long count() {
        return contentRepository.count();
    }
}
