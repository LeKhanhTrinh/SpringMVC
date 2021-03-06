package com.qsoft.business.model;

import com.qsoft.persistent.entity.Customer;

public class ContactBusinessModel {
    int contactNumber;
    Customer customer;
    String contactName;
    String phone;
    String email;
    String jobTitle;
    boolean isMain;

    public ContactBusinessModel(Customer customer, String contactName, String phone, String email, String jobTitle, boolean isMain) {
        this.customer = customer;
        this.contactName = contactName;
        this.phone = phone;
        this.email = email;
        this.jobTitle = jobTitle;
        this.isMain = isMain;
    }

    public ContactBusinessModel(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean isMain) {
        this.isMain = isMain;
    }
}
