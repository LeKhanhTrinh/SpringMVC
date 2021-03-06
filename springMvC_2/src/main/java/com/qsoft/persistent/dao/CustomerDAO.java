package com.qsoft.persistent.dao;

import com.qsoft.persistent.entity.Contact;
import com.qsoft.persistent.entity.Customer;
import com.qsoft.util.PagingObject;

/**
 * Created by hunglv on 4/8/14.
 */
public interface CustomerDAO {
    PagingObject<Customer> getListCustomerDAO(PagingObject<Customer> pagingObject, String criteria);

    String findContactName(Customer customer);

    int getTotalEquipment(Customer customer);

    String getLatestOrder(Customer customer);

    public Contact findContactByCustomer(Customer customer);

    public Customer findCustomerByName(String customerName);

    public Customer findDetailByCustomerId(int idCustomer);
}
