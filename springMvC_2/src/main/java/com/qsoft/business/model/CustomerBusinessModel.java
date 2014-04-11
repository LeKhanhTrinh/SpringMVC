package com.qsoft.business.model;

/**
 * Created by hunglv on 4/10/14.
 */
public class CustomerBusinessModel {
    String customerName;
    String contactName;
    String emailCustomer;
    int totalEquipment;
    String latestOrder;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public int getTotalEquipment() {
        return totalEquipment;
    }

    public void setTotalEquipment(int totalEquipment) {
        this.totalEquipment = totalEquipment;
    }

    public String getLatestOrder() {
        return latestOrder;
    }

    public void setLatestOrder(String latestOrder) {
        this.latestOrder = latestOrder;
    }

}
