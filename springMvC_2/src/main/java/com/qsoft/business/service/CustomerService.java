package com.qsoft.business.service;

import com.qsoft.business.model.CustomerBusinessModel;
import com.qsoft.persistent.dao.CustomerDAO;
import com.qsoft.persistent.dao.impl.CustomerDAOimpl;
import com.qsoft.persistent.entity.Customer;
import com.qsoft.util.PagingObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunglv on 4/10/14.
 */
public class CustomerService {

    public PagingObject<CustomerBusinessModel> getListCustomerBusiness(
            PagingObject<CustomerBusinessModel> pagingObject, String criteria) {

        PagingObject<Customer> pagingObjectCustomer = new PagingObject<Customer>();
        pagingObjectCustomer.setCurrentPage(pagingObject.getCurrentPage());
        pagingObjectCustomer.setSizeOfPage(pagingObject.getSizeOfPage());


        //get pagingObject<Customer>
        CustomerDAO customerDAOimpl = new CustomerDAOimpl();
        pagingObjectCustomer = customerDAOimpl.getListCustomerDAO(pagingObjectCustomer, criteria);


        // convert customerList to customerBusinessModelList....
        List<Customer> customerList = pagingObjectCustomer.getObjects();
        List<CustomerBusinessModel> customerBusinessModelList =  getListCustomerBusiness(customerList);

        //set values for pagingObject
        pagingObject.setObjects(customerBusinessModelList);
        pagingObject.setCurrentPage(pagingObjectCustomer.getCurrentPage());
        pagingObject.setTotalPage(pagingObjectCustomer.getTotalPage());
        pagingObject.setSizeOfPage(pagingObjectCustomer.getSizeOfPage());

        return pagingObject;
    }

    List<CustomerBusinessModel> getListCustomerBusiness(List<Customer> customerList){
        List<CustomerBusinessModel> customerBusinessModelList = new ArrayList<CustomerBusinessModel>();

        for(Customer customer : customerList){
            CustomerBusinessModel customerBusinessModel = new CustomerBusinessModel();
            customerBusinessModel.setCustomerName(customer.getCustomerName());
            customerBusinessModel.setContactName(customer.getContactName());
            customerBusinessModel.setEmailCustomer(customer.getCustomerEmail());

            //set total Equipment
            //set latest order

            customerBusinessModelList.add(customerBusinessModel);
        }

        return customerBusinessModelList;
    }


    int getTotalEquipment(String customerName){
        return 0;
    }

    String getLatestOrder(String cútomerName){
        return "";
    }
}
