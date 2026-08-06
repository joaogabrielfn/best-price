package br.com.bestprice.model;

import java.math.BigDecimal;

public class Product {

    private String name;
    private String brand;
    private String category;
    private BigDecimal lowestPrice;

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
}