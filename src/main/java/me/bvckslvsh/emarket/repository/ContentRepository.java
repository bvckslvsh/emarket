package me.bvckslvsh.emarket.repository;

import me.bvckslvsh.emarket.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    Content findById(long id);
    Content findByTitle(String name);
    List<Content> findAllByOrderById();
}
