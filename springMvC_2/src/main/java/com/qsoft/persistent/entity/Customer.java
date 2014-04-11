package com.qsoft.persistent.entity;

/**
 * Created by hunglv on 4/8/14.
 */
public class Customer {
    int id;
    String customerName;
    String avataLink;
    String contactName;
    String customerPhone;
    String customerAddress;
    String customerFax;
    String customerEmail;

    public Customer() {
    }

    public Customer(int id) {
        this.id = id;
    }

    public Customer(int id, String customerName, String avataLink, String customerPhone,
                    String customerAddress, String customerFax, String customerEmail,  String contactName) {
        this.id = id;
        this.customerName = customerName;
        this.avataLink = avataLink;
        this.contactName = contactName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.customerFax = customerFax;
        this.customerEmail = customerEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAvataLink(String avataLink) {
        this.avataLink = avataLink;
    }

    public String getAvataLink() {
        return avataLink;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerFax() {
        return customerFax;
    }

    public void setCustomerFax(String customerFax) {
        this.customerFax = customerFax;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

}
