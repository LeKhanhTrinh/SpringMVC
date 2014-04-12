package com.qsoft.presentation;

import com.qsoft.business.model.CustomerBusinessModel;
import com.qsoft.business.model.CustomerBusinessModelDetail;
import com.qsoft.business.service.CustomerService;
import com.qsoft.persistent.entity.Customer;
import com.qsoft.util.PagingObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @RequestMapping(value = "/listCustomer", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "currentPage") String currentPage,
                              @RequestParam(value = "criteriaSearch") String criteriaSearch) {
        ModelAndView modelAndView = new ModelAndView("listCustomer");
        PagingObject<CustomerBusinessModel> pagingObject = new PagingObject<CustomerBusinessModel>();

        int currentPageInt = Integer.parseInt(currentPage);
        pagingObject.setCurrentPage(currentPageInt);
        pagingObject.setSizeOfPage(5);
        CustomerService customerService = new CustomerService();
        pagingObject = customerService.getListCustomerBusiness(pagingObject, criteriaSearch);
        modelAndView.addObject("pagingObject", pagingObject);
        modelAndView.addObject("criteriaSearch", criteriaSearch);
        return modelAndView;
    }

    @RequestMapping(value = "/customerDetail", method = RequestMethod.POST)
    public ModelAndView customerDetail(@RequestParam(value = "customerDetail") String customerName) {
        ModelAndView modelAndView = new ModelAndView("customerDetail");
        modelAndView.addObject("customerName", customerName);
        CustomerService customerService = new CustomerService();
        CustomerBusinessModelDetail customerBusinessModelDetail = customerService.findDetailByNameCustomer(customerName);

        modelAndView.addObject("customerInfo", customerBusinessModelDetail);
        System.out.println(customerName);
        return modelAndView;
    }
}
