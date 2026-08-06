package br.com.bestprice.controller;

import br.com.bestprice.model.Product;
import java.math.BigDecimal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("projectName", "BestPrice");
        model.addAttribute(
                "description",
                "Compare peripheral prices and track their changes."
        );

        Product product = new Product(
                "Logitech G305 Mouse",
                "Logitech",
                "Mouse",
                new BigDecimal("189.90")
        );

        model.addAttribute("product", product);

        return "home";
    }
}