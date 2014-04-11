package com.qsoft.persistent.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by hunglv on 4/10/14.
 */
public class Order {
    int orderNumber;
    Contact contact;
    Customer customer;
    Date creationDate;
    Date updatedDate;
    List<OrderDetail> orderDetailList;

    public Order(int orderNumber, Contact contact, Customer customer, Date creationDate,
                 Date updatedDate) {
        this.orderNumber = orderNumber;
        this.contact = contact;
        this.customer = customer;
        this.creationDate = creationDate;
        this.updatedDate = updatedDate;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
