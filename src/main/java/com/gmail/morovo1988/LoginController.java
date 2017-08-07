package com.gmail.morovo1988;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    static final int ITEMS_PER_PAGE = 10;
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService  productService;

    @RequestMapping
    public String loginPage(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<Product> products = productService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        model.addAttribute("types", productService.findTypes());
        model.addAttribute("products",  products);
        model.addAttribute("allPages", getPageCount());
        return "login";
    }
    private long getPageCount() {
        long totalCount = productService.count();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
}
