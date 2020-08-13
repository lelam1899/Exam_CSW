package com.example.exam.service;

import com.example.exam.entity.Product;
import com.example.exam.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAll() {
        return (List<Product>)productRepository.findAll();
    }

    @Override
    public List<Product> list(String search, int status) {
        return null;
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {

        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findProductById(Integer id) {

        return productRepository.findById(id);
    }

    @Override
    public Page<Product> findPaginated(String search, int status, Pageable pageable) {
        return null;
    }

}
