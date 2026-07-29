package br.com.melhorpreco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("nomeProjeto", "MelhorPreço");
        model.addAttribute(
                "descricao",
                "Compare preços de periféricos e acompanhe suas variações."
        );

        return "home";
    }
}