package com.example.pms.service;

import com.example.pms.entity.Product;
import com.example.pms.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.NoSuchElementException;
@Service

@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public Product getProductById(Long productId) {


        return productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException("Product not found with id: " + productId));
    }

    @Override
    public List<Product> getAllProduct() {

        return productRepository.findAll();
    }

    @Override
    @Transactional
    public Product createProduct(Product product) {

        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product updateProductById(Long id,Product product) {
        Product product1 = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
        product1.setPrice(product.getPrice());
        product1.setProductName(product.getProductName());
        productRepository.save(product1);
        return product1;
    }

    @Override
    @Transactional
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }
}
