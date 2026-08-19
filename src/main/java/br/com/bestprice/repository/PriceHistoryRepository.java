package br.com.bestprice.repository;

import br.com.bestprice.model.PriceHistory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Long> {
    List<PriceHistory> findByOfferIdOrderByRecordedDateAsc(Long offerId);
}
