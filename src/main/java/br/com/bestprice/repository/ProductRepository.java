package br.com.bestprice.repository;

import br.com.bestprice.model.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByLowestPriceAsc();

    Optional<Product> findByName(String name);
}
