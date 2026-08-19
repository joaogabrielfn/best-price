package br.com.bestprice.repository;

import br.com.bestprice.model.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByLowestPriceAsc();

    Optional<Product> findByName(String name);

    @Query("""
            SELECT product FROM Product product
            WHERE (:query = '' OR LOWER(product.name) LIKE LOWER(CONCAT('%', :query, '%'))
                    OR LOWER(product.brand) LIKE LOWER(CONCAT('%', :query, '%')))
              AND (:category = '' OR product.category = :category)
            ORDER BY product.lowestPrice ASC
            """)
    List<Product> search(@Param("query") String query, @Param("category") String category);

    @Query("SELECT DISTINCT product.category FROM Product product ORDER BY product.category")
    List<String> findAllCategories();
}
