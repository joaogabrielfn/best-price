package br.com.bestprice.controller;

import br.com.bestprice.model.Product;
import java.math.BigDecimal;
import java.util.List;
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

        List<Product> products = List.of(
                new Product(
                        "Logitech G305 Mouse",
                        "Logitech",
                        "Mouse",
                        new BigDecimal("189.90")
                ),
                new Product(
                        "Redragon Kumara Keyboard",
                        "Redragon",
                        "Keyboard",
                        new BigDecimal("229.90")
                ),
                new Product(
                        "HyperX Cloud Stinger 2 Headset",
                        "HyperX",
                        "Headset",
                        new BigDecimal("249.90")
                )
        );

        model.addAttribute("products", products);

        return "home";
    }
}