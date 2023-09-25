package com.javaadvent.bootrest.repositories;

import org.springframework.data.repository.Repository;
import  com.javaadvent.bootrest.models.Product;
import java.util.List;
import java.util.Optional;


interface ProductRepository extends Repository<Product, String> {
  void delete(Product delete);

  List<Product> findAll();

  Optional<Product> findOne(String id);

  Product save(Product saved);




}
