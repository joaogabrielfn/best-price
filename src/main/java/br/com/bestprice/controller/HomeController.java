package br.com.bestprice.controller;

import br.com.bestprice.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final ProductRepository productRepository;

    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String home(
            @RequestParam(defaultValue = "") String q,
            @RequestParam(defaultValue = "") String category,
            Model model
    ) {
        model.addAttribute("projectName", "BestPrice");
        model.addAttribute(
                "description",
                "Compare peripheral prices and track their changes."
        );

        String query = q.trim();
        String selectedCategory = category.trim();

        model.addAttribute("products", productRepository.search(query, selectedCategory));
        model.addAttribute("categories", productRepository.findAllCategories());
        model.addAttribute("query", query);
        model.addAttribute("selectedCategory", selectedCategory);

        return "home";
    }
}
