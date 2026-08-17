package com.example.pms.service;

import com.example.pms.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    Product getProductById(Long productId);
    List<Product> getAllProduct();
    Product createProduct(Product product);
    Product updateProductById(Long id, Product product);
    void deleteProductById(Long productId);
}
