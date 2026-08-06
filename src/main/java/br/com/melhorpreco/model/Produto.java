package br.com.melhorpreco.model;

import java.math.BigDecimal;

public class Produto {

    private String nome;
    private String marca;
    private String categoria;
    private BigDecimal menorPreco;

    public Produto(
            String nome,
            String marca,
            String categoria,
            BigDecimal menorPreco
    ) {
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.menorPreco = menorPreco;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public BigDecimal getMenorPreco() {
        return menorPreco;
    }
}