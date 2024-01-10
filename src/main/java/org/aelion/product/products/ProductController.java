package org.aelion.product.products;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import validationerrorsprocessor.ProcessErrors;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductServiceImpl service;

    @GetMapping
    public List<Product> findAll() {
        return service.findAll();
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<?> exists(@PathVariable String id) {
        return this.service.exists(id);
    }

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody @Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            // Process with errors
            var processErrors = new ProcessErrors(result);
            return processErrors.processErrors();
        }
        return this.service.add(product);
    }
}
