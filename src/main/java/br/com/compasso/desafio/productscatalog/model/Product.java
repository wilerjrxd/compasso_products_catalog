package br.com.compasso.desafio.productscatalog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import javax.validation.constraints.PositiveOrZero;


@Document
public class Product {

    @Id
    private String id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    @PositiveOrZero
    private Double price;

    public Product(String id, @NonNull String name, @NonNull String description, @NonNull Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @NonNull
    public Double getPrice() {
        return price;
    }

    public void setPrice(@NonNull Double price) {
        this.price = price;
    }
}