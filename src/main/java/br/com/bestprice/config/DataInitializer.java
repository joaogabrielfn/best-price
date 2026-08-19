package br.com.bestprice.config;

import br.com.bestprice.model.Product;
import br.com.bestprice.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadInitialProducts(ProductRepository productRepository) {
        return args -> {
            if (productRepository.count() > 0) {
                return;
            }

            productRepository.saveAll(List.of(
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
            ));
        };
    }
}
