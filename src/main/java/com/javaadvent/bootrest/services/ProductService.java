package com.javaadvent.bootrest.services;

import java.util.List;

interface ProductService {
  ProductDTO create(ProductDTO product);

  ProductDTO delete(String id);

  List<Product> findAll();

  ProductDTO findById(String id);

  ProductDTO update(ProductDTO product);
}
