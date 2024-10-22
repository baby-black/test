package com.example.test.services;
import com.example.test.models.Product;
import com.example.test.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductsService {
    @Autowired
    private ProductsRepository ProductsRepository;


    public List<Product> findAll() {
        return ProductsRepository.findAll();
    }


    public Product findById(Long id) {
        return ProductsRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }


    public Product save(Product Product) {
        return ProductsRepository.save(Product);
    }


    public Product update(Long id, Product Product) {
        return ProductsRepository.save(Product);
    }

    public void delete(Long id) {
        ProductsRepository.deleteById(id);
    }
}