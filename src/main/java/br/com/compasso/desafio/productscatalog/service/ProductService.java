package br.com.compasso.desafio.productscatalog.service;

import br.com.compasso.desafio.productscatalog.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product createOrUpdate(String id, Product product);

    Optional<Product> findById(String id);

    List<Product> findAll();

    void delete(String id);

    List<Product> search(String param, Double minPrice, Double maxPrice);

}
