package me.bvckslvsh.emarket.service;

import me.bvckslvsh.emarket.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void login(String username, String password);
    void save(User user);
    User findByUsername(String username);
    User findByEmail(String email);
    User findById(Long id);
}
