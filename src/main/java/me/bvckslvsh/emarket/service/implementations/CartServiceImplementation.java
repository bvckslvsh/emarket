package me.bvckslvsh.emarket.service.implementations;

import me.bvckslvsh.emarket.domain.Content;
import me.bvckslvsh.emarket.service.CartService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartServiceImplementation implements CartService {
    private Map<Content, Integer> cart = new LinkedHashMap<>();


    @Override
    public void addContent(Content content) {
        if(cart.containsKey(content)){
            cart.replace(content, cart.get(content) + 1);
        }else{
            cart.put(content, 1);
        }
    }

    @Override
    public void removeContent(Content content) {
        if(cart.containsKey(content)){
            if (cart.get(content) > 1){
                cart.replace(content, cart.get(content) - 1);
            }else if (cart.get(content) == 1){
                cart.remove(content);
            }
        }
    }

    @Override
    public void clearCart() {
        cart.clear();
    }

    @Override
    public Map<Content, Integer> contentInCart() {
        return Collections.unmodifiableMap(cart);
    }

    @Override
    public void checkout() {
        //dummy
    }

    @Override
    public BigDecimal totalPrice() {
        return cart.entrySet().stream()
                .map(c -> c.getKey().getPrice().multiply(BigDecimal.valueOf(c.getValue()))).sorted()
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
