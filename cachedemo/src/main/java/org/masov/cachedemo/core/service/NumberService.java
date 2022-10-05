package org.masov.cachedemo.core.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class NumberService {

    public BigDecimal square(BigDecimal value) {
        return value.multiply(value);
    }

    @Cacheable(
            value = "squareCache",
            key = "#value",
            condition = "#value>10")
    public BigDecimal square(Long value) {
        BigDecimal bdv = BigDecimal.valueOf(value);
        return bdv.multiply(bdv);
    }
}
