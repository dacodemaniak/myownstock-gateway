package org.aelion.product.products;

import org.aelion.product.products.dto.ProductAlreadyExistsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl {
    private List<Product> products = new ArrayList<>();

    public ProductServiceImpl() {
        this.populate();
    }
    public List<Product> findAll() {
        return this.products;
    }

    public ResponseEntity<?> add(Product product) {
        if (!this.checkIfExists(product.getId())) {
            this.products.add(product);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ProductAlreadyExistsDto("Product with Id : " + product.getId() + " already exists"));
    }
    public ResponseEntity<?> exists(String id) {
        return this.checkIfExists(id) ? ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }

    private boolean checkIfExists(String id) {
        return this.products.stream()
                .filter(p -> p.getId().equals(id))
                .collect(Collectors.toList())
                .size() > 0;
    }
    private void populate() {
        this.products.add(new Product("1ea77", "Pommes", 10));
        this.products.add(new Product("234ff", "Pâtes", 5));
        this.products.add(new Product("ff2a3", "Raviolis", 3));
    }
}
