package com.example.order.management.system.service;

import com.example.order.management.system.entity.Product;
import com.example.order.management.system.exception.ResourceNotFoundException;
import com.example.order.management.system.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product, long id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product", id, "id"));
        existingProduct.setName(product.getName());
        existingProduct.setSkuCode(product.getSkuCode());
        existingProduct.setUnitPrice(product.getUnitPrice());
        productRepository.save(existingProduct);
        return existingProduct;
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
