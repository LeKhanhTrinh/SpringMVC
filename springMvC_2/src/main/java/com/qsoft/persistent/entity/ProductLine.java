package com.qsoft.persistent.entity;

/**
 * Created by Administrator on 4/11/14.
 */
public class ProductLine {
    int idProductLine;
    String name;
    String description;

    public ProductLine(int idProductLine, String name, String description) {
        this.idProductLine = idProductLine;
        this.name = name;
        this.description = description;
    }
}
