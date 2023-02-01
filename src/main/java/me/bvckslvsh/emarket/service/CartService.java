package me.bvckslvsh.emarket.service;


import me.bvckslvsh.emarket.domain.Content;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
@Service
public interface CartService {

    void addContent(Content content);
    void removeContent(Content content);
    void clearCart();
    Map<Content, Integer> contentInCart();
    void checkout();
    BigDecimal totalPrice();

}
