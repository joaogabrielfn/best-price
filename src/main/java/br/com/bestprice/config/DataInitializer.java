package br.com.bestprice.config;

import br.com.bestprice.model.Offer;
import br.com.bestprice.model.PriceHistory;
import br.com.bestprice.model.Product;
import br.com.bestprice.model.Store;
import br.com.bestprice.repository.OfferRepository;
import br.com.bestprice.repository.PriceHistoryRepository;
import br.com.bestprice.repository.ProductRepository;
import br.com.bestprice.repository.StoreRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadInitialData(ProductRepository products, StoreRepository stores,
            OfferRepository offers, PriceHistoryRepository histories) {
        return args -> {
            createProducts(products);
            if (offers.count() > 0) return;

            Store amazon = stores.save(new Store("Amazon", "https://www.amazon.com.br"));
            Store kabum = stores.save(new Store("KaBuM!", "https://www.kabum.com.br"));
            Store pichau = stores.save(new Store("Pichau", "https://www.pichau.com.br"));
            Product mouse = requiredProduct(products, "Logitech G305 Mouse");
            Product keyboard = requiredProduct(products, "Redragon Kumara Keyboard");
            Product headset = requiredProduct(products, "HyperX Cloud Stinger 2 Headset");

            Offer mouseAmazon = offers.save(new Offer(mouse, amazon, money("189.90"), amazon.getWebsiteUrl()));
            offers.save(new Offer(mouse, kabum, money("199.90"), kabum.getWebsiteUrl()));
            offers.save(new Offer(mouse, pichau, money("205.50"), pichau.getWebsiteUrl()));
            Offer keyboardKabum = offers.save(new Offer(keyboard, kabum, money("229.90"), kabum.getWebsiteUrl()));
            offers.save(new Offer(keyboard, amazon, money("239.90"), amazon.getWebsiteUrl()));
            Offer headsetPichau = offers.save(new Offer(headset, pichau, money("249.90"), pichau.getWebsiteUrl()));
            offers.save(new Offer(headset, amazon, money("269.90"), amazon.getWebsiteUrl()));

            histories.saveAll(List.of(
                    history(mouseAmazon, "229.90", 28), history(mouseAmazon, "209.90", 21),
                    history(mouseAmazon, "199.90", 14), history(mouseAmazon, "189.90", 7),
                    history(keyboardKabum, "259.90", 21), history(keyboardKabum, "244.90", 14),
                    history(keyboardKabum, "229.90", 7),
                    history(headsetPichau, "289.90", 21), history(headsetPichau, "269.90", 14),
                    history(headsetPichau, "249.90", 7)
            ));
        };
    }

    private void createProducts(ProductRepository products) {
        if (products.count() > 0) return;
        products.saveAll(List.of(
                new Product("Logitech G305 Mouse", "Logitech", "Mouse", money("189.90")),
                new Product("Redragon Kumara Keyboard", "Redragon", "Keyboard", money("229.90")),
                new Product("HyperX Cloud Stinger 2 Headset", "HyperX", "Headset", money("249.90"))
        ));
    }

    private Product requiredProduct(ProductRepository products, String name) {
        return products.findByName(name)
                .orElseThrow(() -> new IllegalStateException("Product not found: " + name));
    }

    private PriceHistory history(Offer offer, String price, int daysAgo) {
        return new PriceHistory(offer, money(price), LocalDate.now().minusDays(daysAgo));
    }

    private BigDecimal money(String value) { return new BigDecimal(value); }
}
