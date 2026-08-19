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

@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "product_url", nullable = false, length = 500)
    private String productUrl;

    @Column(nullable = false)
    private boolean active = true;

    protected Offer() {}

    public Offer(Product product, Store store, BigDecimal price, String productUrl) {
        this.product = product;
        this.store = store;
        this.price = price;
        this.productUrl = productUrl;
    }

    public Long getId() { return id; }
    public Product getProduct() { return product; }
    public Store getStore() { return store; }
    public BigDecimal getPrice() { return price; }
    public String getProductUrl() { return productUrl; }
    public boolean isActive() { return active; }
}
