package br.com.melhorpreco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.melhorpreco.model.Produto;
import java.math.BigDecimal;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("nomeProjeto", "MelhorPreço");
        model.addAttribute(
                "descricao",
                "Compare preços de periféricos e acompanhe suas variações."
        );

        Produto produto = new Produto(
        "Mouse Logitech G305",
        "Logitech",
        "Mouse",
        new BigDecimal("189.90")
        );

        model.addAttribute("produto", produto);

        return "home";
    }
}