package br.com.bestprice.controller;

import br.com.bestprice.model.Offer;
import br.com.bestprice.model.PriceHistory;
import br.com.bestprice.model.Product;
import br.com.bestprice.repository.OfferRepository;
import br.com.bestprice.repository.PriceHistoryRepository;
import br.com.bestprice.repository.ProductRepository;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class ProductController {
    private final ProductRepository productRepository;
    private final OfferRepository offerRepository;
    private final PriceHistoryRepository priceHistoryRepository;

    public ProductController(ProductRepository productRepository, OfferRepository offerRepository,
            PriceHistoryRepository priceHistoryRepository) {
        this.productRepository = productRepository;
        this.offerRepository = offerRepository;
        this.priceHistoryRepository = priceHistoryRepository;
    }

    @GetMapping("/products/{id}")
    public String details(@PathVariable Long id, Model model) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<Offer> offers = offerRepository.findByProductIdAndActiveTrueOrderByPriceAsc(id);
        List<PriceHistory> history = offers.isEmpty() ? List.of()
                : priceHistoryRepository.findByOfferIdOrderByRecordedDateAsc(offers.get(0).getId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");

        model.addAttribute("product", product);
        model.addAttribute("offers", offers);
        model.addAttribute("historyLabels", history.stream()
                .map(item -> item.getRecordedDate().format(formatter)).toList());
        model.addAttribute("historyPrices", history.stream().map(PriceHistory::getPrice).toList());
        return "product-details";
    }
}
