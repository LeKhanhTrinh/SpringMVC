package com.qsoft.persistent.entity;

public class Contact {
    int contactNumber;
    Customer customer;
    String phone;
    String email;
    String jobTitle;
    boolean isMain;

    public Contact(int contactNumber, Customer customer, String phone, String email, String jobTitle, boolean isMain) {
        this.contactNumber = contactNumber;
        this.customer = customer;
        this.phone = phone;
        this.email = email;
        this.jobTitle = jobTitle;
        this.isMain = isMain;
    }

    public Contact(int contactNumber) {
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
