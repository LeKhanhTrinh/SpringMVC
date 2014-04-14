package com.qsoft.business.model;

import com.qsoft.persistent.entity.Order;
import com.qsoft.persistent.entity.Product;

/**
 * Created by hunglv on 4/14/14.
 */
public class OrderDetailBusinessModel {
    Order order;
    Product product;
    int quantityOrdered;
    double priceEach;
    String description;

    public OrderDetailBusinessModel() {
    }

    public OrderDetailBusinessModel(Order order, Product product, int quantityOrdered, double priceEach, String description) {
        this.order = order;
        this.product = product;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
