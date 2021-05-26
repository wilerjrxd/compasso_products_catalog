package br.com.compasso.desafio.productscatalog.repository;

import br.com.compasso.desafio.productscatalog.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByNameOrDescriptionAndPriceBetween(String name, String description,
                                                         Double minPrice, Double maxPrice);

}
