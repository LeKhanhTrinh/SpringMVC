package com.qsoft.business.service;

import com.qsoft.business.model.CustomerBusinessModel;
import com.qsoft.business.model.CustomerBusinessModelDetail;
import com.qsoft.persistent.dao.CustomerDAO;
import com.qsoft.persistent.dao.impl.CustomerDAOimpl;
import com.qsoft.persistent.entity.Contact;
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
            CustomerDAO customerDAO = new CustomerDAOimpl();
            customerBusinessModel.setContactName(customerDAO.findContactName(customer));
            customerBusinessModel.setEmailCustomer(customer.getCustomerEmail());

            //set total Equipment
            customerBusinessModel.setTotalEquipment(customerDAO.getTotalEquipment(customer));
            //set latest order
            customerBusinessModel.setLatestOrder(customerDAO.getLatestOrder(customer));

            customerBusinessModelList.add(customerBusinessModel);
        }

        return customerBusinessModelList;
    }

    public CustomerBusinessModelDetail findDetailByNameCustomer(String nameCus){

        CustomerBusinessModelDetail customerBusinessModelDetail = new CustomerBusinessModelDetail();
        customerBusinessModelDetail.setCustomerName(nameCus);
        CustomerDAO customerDAO = new CustomerDAOimpl();

        Customer customer = customerDAO.findCustomerByName(nameCus);
        Contact contact = customerDAO.findContactByCustomer(customer);

        customerBusinessModelDetail.setAddress(customer.getCustomerAddress());
        customerBusinessModelDetail.setConPhone(customer.getCustomerPhone());
        customerBusinessModelDetail.setCusFax(customer.getCustomerFax());
        customerBusinessModelDetail.setContactName(contact.getContactName());
        customerBusinessModelDetail.setCusPhone(contact.getPhone());
        customerBusinessModelDetail.setConEmail(contact.getEmail());
        customerBusinessModelDetail.setAvt(customer.getAvataLink());
        customerBusinessModelDetail.setCustomerNumber(customer.getId());

        return customerBusinessModelDetail;
    }



    public Customer findCustomerByName (String customerName){
        CustomerDAO customerDAO = new CustomerDAOimpl();
        Customer customer = customerDAO.findCustomerByName(customerName);
        return customer;
    }

}
