package br.com.bestprice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "price_history")
public class PriceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "offer_id", nullable = false)
    private Offer offer;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "recorded_date", nullable = false)
    private LocalDate recordedDate;

    protected PriceHistory() {}

    public PriceHistory(Offer offer, BigDecimal price, LocalDate recordedDate) {
        this.offer = offer;
        this.price = price;
        this.recordedDate = recordedDate;
    }

    public Long getId() { return id; }
    public Offer getOffer() { return offer; }
    public BigDecimal getPrice() { return price; }
    public LocalDate getRecordedDate() { return recordedDate; }
}
