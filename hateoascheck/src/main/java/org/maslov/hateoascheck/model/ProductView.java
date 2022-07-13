package org.maslov.hateoascheck.model;


import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductView extends RepresentationModel<ProductView> implements Product {

    private Long id;

    private String name;

    private Long price;


    private Currency currency;
}
