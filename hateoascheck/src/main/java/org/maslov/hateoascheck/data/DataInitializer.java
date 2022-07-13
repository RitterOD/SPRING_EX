package org.maslov.hateoascheck.data;

import org.maslov.hateoascheck.model.Currency;
import org.maslov.hateoascheck.model.ProductEntity;
import org.maslov.hateoascheck.repository.ProductEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductEntityRepository productEntityRepository;

    public DataInitializer(ProductEntityRepository productEntityRepository) {
        this.productEntityRepository = productEntityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i = 0; i < 10; ++i) {
            var tmpProduct = ProductEntity.builder()
                    .name("Coffee #" + i)
                    .price(1L + 10 * i)
                    .currency(Currency.RUB)
                    .build();
            productEntityRepository.save(tmpProduct);
        }

    }
}
