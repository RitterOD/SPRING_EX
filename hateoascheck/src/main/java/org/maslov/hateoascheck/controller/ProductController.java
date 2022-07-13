package org.maslov.hateoascheck.controller;

import org.maslov.hateoascheck.model.Currency;
import org.maslov.hateoascheck.model.Product;
import org.maslov.hateoascheck.model.ProductEntity;
import org.maslov.hateoascheck.model.ProductView;
import org.maslov.hateoascheck.service.ProductService;
import org.maslov.hateoascheck.service.ProductViewMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductViewMapper productViewMapper;

    public ProductController(ProductService productService, ProductViewMapper productViewMapper) {
        this.productService = productService;
        this.productViewMapper = productViewMapper;
    }



    public  static  class ProductRepresentation extends RepresentationModel<ProductView> implements Product {
        public ProductRepresentation(ProductView productView) {
            this.productView = productView;
        }

        private final ProductView productView;


        @Override
        public Long getId() {
            return productView.getId();
        }

        @Override
        public void setId(Long id) {
            productView.setId(id);
        }

        @Override
        public String getName() {
            return productView.getName();
        }

        @Override
        public void setName(String name) {
            productView.setName(name);
        }

        @Override
        public Long getPrice() {
            return productView.getPrice();
        }

        @Override
        public void setPrice(Long price) {
            productView.setPrice(price);
        }

        @Override
        public Currency getCurrency() {
            return productView.getCurrency();
        }

        @Override
        public void setCurrency(Currency currency) {
            productView.setCurrency(currency);
        }
    }

    @GetMapping("/{id}")
    public ProductRepresentation findById(@PathVariable Long id) {
        var entity = productService.findById(id).map(e -> productViewMapper.map(e)).orElseThrow(() -> new IllegalArgumentException("Not found"));
        var rv = new ProductRepresentation(entity);
        Link selfLink = linkTo(ProductController.class).slash(entity.getId()).withSelfRel();
        rv.add(selfLink);
        return rv;
    }

    @GetMapping("")
    public CollectionModel findAll() {
        var entities = productService.findAll().stream().map(productViewMapper::map)
                .map(e -> {Link tmp = linkTo(ProductController.class).slash(e.getId()).withSelfRel(); e.add(tmp); return e;})
                .collect(Collectors.toList());
        Link selfLink = linkTo(ProductController.class).withSelfRel();
        var rv = CollectionModel.of(entities, selfLink);
        return rv;
    }
}
