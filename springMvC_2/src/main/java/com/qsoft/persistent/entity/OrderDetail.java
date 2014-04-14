package com.qsoft.persistent.entity;

/**
 * Created by hunglv on 4/10/14.
 */
public class OrderDetail {
    Order order;
    Product product;
    int quantityOrdered;
    double priceEach;

    public OrderDetail() {
    }

    public OrderDetail(Order order, Product product, int quantityOrdered, double priceEach) {
        this.order = order;
        this.product = product;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
    }

    public OrderDetail(Order order) {
        this.order = order;
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
}
