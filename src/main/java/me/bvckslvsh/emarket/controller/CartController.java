package me.bvckslvsh.emarket.controller;

import me.bvckslvsh.emarket.domain.Content;
import me.bvckslvsh.emarket.service.CartService;
import me.bvckslvsh.emarket.service.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);
    private final CartService cartService;
    private final ContentService contentService;

    @Autowired
    public CartController(CartService cartService, ContentService contentService) {
        this.cartService = cartService;
        this.contentService = contentService;
    }



    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("contents", cartService.contentInCart());
        model.addAttribute("totalPrice", cartService.totalPrice());
        return "cart";
    }

    @GetMapping("/cart/clear")
    public String clearCart(){
        cartService.clearCart();

        return "redirect:/cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable("id") Long id) {
        Content content = contentService.findById(id);
        if (content != null){
            cartService.addContent(content);
            logger.debug(String.format("Content id: %s added to cart id:", id));
        }
        return "redirect:/cart";
    }

    public String checkout(){
        cartService.checkout();
        return "redirect:/cart";
    }
}
