package com.app.product.service;

import com.app.product.entities.Product;
import com.app.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public List<Product> saveProducts(List<Product> products) {

        return productRepository.saveAll(products);
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getProductId())
                .orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName().toUpperCase());
            existingProduct.setPrice(product.getPrice());
            return productRepository.save(existingProduct);
        }
        return null;
    }
}
