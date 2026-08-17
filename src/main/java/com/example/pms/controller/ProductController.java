package com.example.pms.controller;

import com.example.pms.entity.Product;
import com.example.pms.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){
        Product product1 = productService.createProduct(product);
        return ResponseEntity.ok( product1);
    }
    @GetMapping("{id}")
    public  ResponseEntity<Product> getProductById(@PathVariable("id") Long id ){
        Product product = productService.getProductById(id);

        return ResponseEntity.ok(product);
    }
    @GetMapping
    public  ResponseEntity<List<Product>> getProducts(){
        List<Product> product = productService.getAllProduct();

        return ResponseEntity.ok(product);
    }
    @PutMapping("{id}")
    public ResponseEntity<Product> putProductById(@PathVariable("id")  Long id,@Valid @RequestBody Product product){
        Product product1 = productService.updateProductById(id,product);
        return ResponseEntity.ok(product1);
    }
    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable("id") Long id){
        productService.deleteProductById(id);
    }


}
