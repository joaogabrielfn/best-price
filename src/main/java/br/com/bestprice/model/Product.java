package br.com.bestprice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 80)
    private String brand;

    @Column(nullable = false, length = 60)
    private String category;

    @Column(name = "lowest_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal lowestPrice;

    protected Product() {
    }

    public Product(
            String name,
            String brand,
            String category,
            BigDecimal lowestPrice
    ) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.lowestPrice = lowestPrice;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(BigDecimal lowestPrice) {
        this.lowestPrice = lowestPrice;
    }
}
