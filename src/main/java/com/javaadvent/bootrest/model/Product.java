package com.javaadvent.bootrest.model;

import org.springframework.data.annotation.Id;

import static com.javaadvent.bootrest.util.PreCondition.isTrue;
import static com.javaadvent.bootrest.util.PreCondition.notEmpty;
import static com.javaadvent.bootrest.util.PreCondition.notNull;


final class Product {
  static final int MAX_LENGTH_DESCRIPTION = 500;
  static final int MAX_LENGTH_TITLE = 100;

  @Id
  private String id;

  private String name;

  private double price;
  
  private int stock;

  private Product(Builder builder) {
    this.name = builder.name;
    this.price = builder.price;
    this.stock = builder.stock;

  }

  static Builder getBuilder() {
    return new Builder();
  }




}
