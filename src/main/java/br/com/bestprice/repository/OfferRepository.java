package br.com.bestprice.repository;

import br.com.bestprice.model.Offer;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    @EntityGraph(attributePaths = "store")
    List<Offer> findByProductIdAndActiveTrueOrderByPriceAsc(Long productId);
}
