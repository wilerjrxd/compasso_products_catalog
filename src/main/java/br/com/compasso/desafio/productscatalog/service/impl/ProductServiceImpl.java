package br.com.compasso.desafio.productscatalog.service.impl;

import br.com.compasso.desafio.productscatalog.exception.NotFoundException;
import br.com.compasso.desafio.productscatalog.model.Product;
import br.com.compasso.desafio.productscatalog.repository.ProductRepository;
import br.com.compasso.desafio.productscatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createOrUpdate(String id, Product product) {
        Optional<Product> productById = null;
        if (id != null) {
            productById = this.productRepository.findById(id);
            if (!productById.isPresent()) {
                throw new NotFoundException("Product not found");
            }
            product.setId(id);
        }
        try {
            return this.productRepository.save(product);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Optional<Product> findById(String id) {
        try {
            return this.productRepository.findById(id);
        } catch (NotFoundException e) {
            throw new NotFoundException("Product not found");
        }
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public void delete(String id) {
        Optional<Product> productById = this.productRepository.findById(id);
        try {
            this.productRepository.delete(productById.get());
        } catch (NotFoundException e) {
            throw new NotFoundException("Product not found");
        }

    }

    @Override
    public List<Product> search(String q, Double minPrice, Double maxPrice) {
        return this.productRepository.findByNameOrDescriptionAndPriceBetween(q, q, minPrice, maxPrice);
    }
}
