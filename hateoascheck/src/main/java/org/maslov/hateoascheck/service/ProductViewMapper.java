package org.maslov.hateoascheck.service;

import org.maslov.hateoascheck.model.ProductEntity;
import org.maslov.hateoascheck.model.ProductView;
import org.springframework.stereotype.Service;

@Service
public class ProductViewMapper {

    public ProductView map(ProductEntity entity) {
        return ProductView.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .currency(entity.getCurrency())
                .build();

    }
}
