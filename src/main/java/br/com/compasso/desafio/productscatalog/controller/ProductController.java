package br.com.compasso.desafio.productscatalog.controller;

import br.com.compasso.desafio.productscatalog.exception.NotFoundException;
import br.com.compasso.desafio.productscatalog.model.Product;
import br.com.compasso.desafio.productscatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(this.productService.createOrUpdate(null, product), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable("id") String id) {
        return ResponseEntity.ok(this.productService.createOrUpdate(id, product));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable("id") String id) {
        try {
            Optional<Product> product = this.productService.findById(id);
            return ResponseEntity.ok(product);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = this.productService.findAll();

        return ResponseEntity.ok(products);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<Product>> findByParams(
            @RequestParam(value = "q", required = false) String nameDesc,
            @RequestParam(value = "min_price", required = false) Double minPrice,
            @RequestParam(value = "max_price", required = false) Double maxPrice) {

        return ResponseEntity.ok(this.productService.search(nameDesc, minPrice, maxPrice));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {

        try {
            this.productService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
