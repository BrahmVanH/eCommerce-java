package com.javaadvent.bootrest.models;

import org.springframework.data.annotation.Id;

import static com.javaadvent.bootrest.util.PreCondition.isTrue;
import static com.javaadvent.bootrest.util.PreCondition.notEmpty;
import static com.javaadvent.bootrest.util.PreCondition.notNull;

final class Product {
  static final int MAX_LENGTH_NAME = 100;

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

  // Getters

  private String getId() {
    return this.id;
  }

  private String getName() {
    return this.name;
  }

  private double getPrice() {
    return this.price;
  }

  private int getStock() {
    return this.stock;
  }

  public void update(String name, double price, int stock) {
    checkValues(name, price, stock);

    this.name = name;
    this.price = price;
    this.stock = stock;
  }

  static class Builder {
    private String name;
    private double price;
    private int stock;

    private Builder() {
    };

    Builder name(String name) {
      this.name = name;

      return this;
    }

    Builder price(double price) {
      this.price = price;

      return this;
    }

    Builder stock(int stock) {
      this.stock = stock;

      return this;
    }

    Product build() {
      Product build = new Product(this);

      build.checkValues(build.getName(), build.getPrice(), build.getStock());

      return build;
    }

  }

  private void checkValues(String name, double price, int stock) {
    notNull(name, "The product name cannot be null!");
    notEmpty(name, "The product name cannot be empty!");
    isTrue(name.length() <= MAX_LENGTH_NAME,
        "Title cannot be longer than %d characters", MAX_LENGTH_NAME
        );

    notNull(price, "The product price cannot be null!");
    notEmpty(price, "The product price cannot be empty!");

    notNull(stock, "The product stock cannot be null!");
    notEmpty(stock, "The product stock cannot be empty!");
  }

}
