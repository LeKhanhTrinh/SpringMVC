package com.qsoft.persistent.dao;

import com.qsoft.business.model.CustomerBusinessModel;
import com.qsoft.persistent.entity.Customer;
import com.qsoft.util.PagingObject;

import java.util.List;

/**
 * Created by hunglv on 4/8/14.
 */
public interface CustomerDAO {
    PagingObject<Customer> getListCustomerDAO(PagingObject<Customer> pagingObject, String criteria);
    String findContactName(int customerID);
    int getTotalEquipment(Customer customer);
    String getLatestOrder(Customer customer);
}
