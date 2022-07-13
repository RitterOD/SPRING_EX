package org.maslov.hateoascheck.service;

import org.maslov.hateoascheck.model.ProductEntity;
import org.maslov.hateoascheck.repository.ProductEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductEntityRepository productEntityRepository;

    public ProductService(ProductEntityRepository productEntityRepository) {
        this.productEntityRepository = productEntityRepository;
    }

    public List<ProductEntity> findAll() {
        return productEntityRepository.findAll();
    }

    public Optional<ProductEntity> findById(Long id) {
        return productEntityRepository.findById(id);
    }

    public void deleteById(Long id) {
        productEntityRepository.deleteById(id);
    }

    public ProductEntity update(ProductEntity productEntity) {
        return productEntityRepository.save(productEntity);
    }
}
