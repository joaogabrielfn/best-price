package br.com.bestprice.controller;

import br.com.bestprice.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ProductRepository productRepository;

    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("projectName", "BestPrice");
        model.addAttribute(
                "description",
                "Compare peripheral prices and track their changes."
        );

        model.addAttribute(
                "products",
                productRepository.findAllByOrderByLowestPriceAsc()
        );

        return "home";
    }
}
