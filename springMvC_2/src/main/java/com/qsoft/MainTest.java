package com.qsoft;

import com.qsoft.business.model.CustomerBusinessModel;
import com.qsoft.business.service.CustomerService;
import com.qsoft.persistent.dao.CustomerDAO;
import com.qsoft.util.PagingObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hunglv on 4/10/14.
 */
public class MainTest {
    public static void main(String[] args) {
        PagingObject<CustomerBusinessModel> pagingObject = new PagingObject<CustomerBusinessModel>();
        pagingObject.setCurrentPage(1);
        pagingObject.setSizeOfPage(5);
        pagingObject.setObjects(null);

        CustomerService customerService = new CustomerService();
        pagingObject = customerService.getListCustomerBusiness(pagingObject, "a");
        for(CustomerBusinessModel customer : pagingObject.getObjects()){
            System.out.println(customer.getCustomerName());
        }
    }
}
