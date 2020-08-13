package com.example.exam.service;

import com.example.exam.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Iterable<Product> getAllProducts();

    public List<Product> getAll();
    List<Product> list(String search, int status);

    void saveProduct(Product product);

    void deleteProduct(Integer id);

    Optional<Product> findProductById(Integer id);
    Page<Product> findPaginated(String search, int status, Pageable pageable);
}
