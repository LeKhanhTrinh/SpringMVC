package com.qsoft.persistent.entity;

public class Product {
    String serialProduct;
    String productName;
    ProductLine ProductLine;
    String modelProduct;
    int year;

    public Product(String serialProduct, ProductLine productLine, String modelProduct, int year) {
        this.serialProduct = serialProduct;
        ProductLine = productLine;
        this.modelProduct = modelProduct;
        this.year = year;
    }

    public Product(String serialProduct) {
        this.serialProduct = serialProduct;
    }

    public String getSerialProduct() {
        return serialProduct;
    }

    public void setSerialProduct(String serialProduct) {
        this.serialProduct = serialProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductLine getProductLine() {
        return ProductLine;
    }

    public void setProductLine(ProductLine productLine) {
        ProductLine = productLine;
    }

    public String getModelProduct() {
        return modelProduct;
    }

    public void setModelProduct(String modelProduct) {
        this.modelProduct = modelProduct;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return getSerialProduct() + ", " + getProductLine().getName() + ", " + getModelProduct() + ", " + getYear();
    }
}
