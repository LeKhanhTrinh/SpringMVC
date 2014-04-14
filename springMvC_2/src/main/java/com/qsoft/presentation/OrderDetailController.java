package com.qsoft.presentation;

import com.qsoft.business.model.CustomerBusinessModelDetail;
import com.qsoft.business.model.OrderBusinessModel;
import com.qsoft.business.model.OrderDetailBusinessModel;
import com.qsoft.business.service.CustomerService;
import com.qsoft.business.service.OrderDetailService;
import com.qsoft.business.service.OrderService;
import com.qsoft.persistent.entity.Customer;
import com.qsoft.persistent.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by hunglv on 4/14/14.
 */
@Controller
public class OrderDetailController {
    @RequestMapping(value = "/orderDetail", method = RequestMethod.GET)
    public ModelAndView goOrderDetail(@RequestParam("customerId") String customerID,
                                      @RequestParam("orderId") String orderId) {
        ModelAndView modelAndView = new ModelAndView("orderDetail");
        modelAndView.addObject("orderID", orderId);


        CustomerService customerService = new CustomerService();
        CustomerBusinessModelDetail customerBusinessModelDetail =
                customerService.findDetailByCustomerId(Integer.parseInt(customerID));
        modelAndView.addObject("customerInfo", customerBusinessModelDetail);

        Customer customer = new Customer(Integer.parseInt(customerID));


        OrderService orderService = new OrderService();
        OrderBusinessModel orderBusinessModel = orderService.getOrderFromId(Integer.parseInt(orderId));
        modelAndView.addObject("creationDate", orderBusinessModel.getCreationDate());

        Order order = new Order(Integer.parseInt(orderId));
        OrderDetailService orderDetailService = new OrderDetailService();
        List<OrderDetailBusinessModel> orderDetailList =
                orderDetailService.getListOrderDetailBusinessModel(customer, order);
        modelAndView.addObject("orderDetailList", orderDetailList);

        double totalOrder = orderDetailService.getTotalOrderDetails(orderDetailList);
        modelAndView.addObject("totalOrder", totalOrder);

        System.out.println(customerID + ": " + orderId);

        return modelAndView;
    }
}
