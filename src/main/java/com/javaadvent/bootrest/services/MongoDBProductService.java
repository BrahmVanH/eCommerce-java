package com.javaadvent.bootrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
final class MongoDBProductService implements ProductService {
  
  private final ProductRepository repository;

  @Autowired
  MongoDBProductService(ProductRepository repository) {
    this.repository = repository;
  }

  @Override
  public ProductDTO create(ProductDTO product) {
    Product persisted = Product.getBuilder()
                    .name(product.getName())
                    .price(product.getPrice())
                    .stock(product.getStock())
                    .build();
            persisted = repository.save(persisted);
            return convertProductDTO(persisted);
  }
}
