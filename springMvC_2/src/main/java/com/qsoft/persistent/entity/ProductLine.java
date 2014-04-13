package com.qsoft.persistent.entity;

/**
 * Created by Administrator on 4/11/14.
 */
public class ProductLine {
    int idProductLine;
    String name;
    String description;

    public ProductLine(String name) {
        this.name = name;
    }

    public ProductLine(int idProductLine, String name, String description) {
        this.idProductLine = idProductLine;
        this.name = name;
        this.description = description;
    }

    public int getIdProductLine() {
        return idProductLine;
    }

    public void setIdProductLine(int idProductLine) {
        this.idProductLine = idProductLine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
