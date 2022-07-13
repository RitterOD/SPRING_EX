package org.maslov.hateoascheck.model;

public interface Product {


    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);

    Long getPrice();
    void setPrice(Long price);

    Currency getCurrency();
    void setCurrency(Currency currency);
}
