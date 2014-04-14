package com.qsoft.presentation;

import com.qsoft.business.model.EquipmentBusinessModel;
import com.qsoft.business.model.OrderListBusinessModel;
import com.qsoft.business.service.EquipmentService;
import com.qsoft.business.service.OrderService;
import com.qsoft.persistent.entity.Customer;
import com.qsoft.util.PagingObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
    @RequestMapping(value = "/order", method= RequestMethod.GET)
    public ModelAndView goOrderFirst( @RequestParam("customer") String customerID) {
        ModelAndView modelAndView = new ModelAndView("ListOrder");

        PagingObject<OrderListBusinessModel> orderListBusinessModelPagingObject = new PagingObject<OrderListBusinessModel>();
        orderListBusinessModelPagingObject.setCurrentPage(1);
        orderListBusinessModelPagingObject.setSizeOfPage(5);

        int idCustomer = Integer.parseInt(customerID);
        Customer customer = new Customer(idCustomer);
        OrderService orderService = new OrderService();
        orderListBusinessModelPagingObject = orderService.getListOrderBusinessModel(
                orderListBusinessModelPagingObject, customer);

        modelAndView.addObject("customerId", idCustomer);
        modelAndView.addObject("pagingObject", orderListBusinessModelPagingObject);

        for(OrderListBusinessModel model : orderListBusinessModelPagingObject.getObjects()){
            System.out.println(model.getContactName());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/orderList", method= RequestMethod.POST)
    public ModelAndView goOrderMore( @RequestParam("customerId") String customerID,
                                         @RequestParam ("currentPage") String currentPage) {

        ModelAndView modelAndView = new ModelAndView("ListOrder");

        PagingObject<OrderListBusinessModel> orderListBusinessModelPagingObject =
                new PagingObject<OrderListBusinessModel>();
        orderListBusinessModelPagingObject.setCurrentPage(Integer.parseInt(currentPage));
        orderListBusinessModelPagingObject.setSizeOfPage(5);
        int idCustomer = Integer.parseInt(customerID);
        Customer customer = new Customer(idCustomer);
        OrderService orderService = new OrderService();
        orderListBusinessModelPagingObject =
                orderService.getListOrderBusinessModel(orderListBusinessModelPagingObject, customer);

        modelAndView.addObject("customerId", customerID);
        modelAndView.addObject("pagingObject", orderListBusinessModelPagingObject);
        return modelAndView;
    }
}
