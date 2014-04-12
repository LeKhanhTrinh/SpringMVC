package com.qsoft.presentation;

import com.qsoft.business.model.CustomerBusinessModel;
import com.qsoft.business.service.CustomerService;
import com.qsoft.util.PagingObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password) {
        if (username.equals("admin") && password.equals("123")) {
            ModelAndView model = new ModelAndView("listCustomer");
            model.addObject("username", username);

            PagingObject<CustomerBusinessModel> pagingObject = new PagingObject<CustomerBusinessModel>();
            pagingObject.setCurrentPage(1);
            pagingObject.setSizeOfPage(5);
            CustomerService customerService = new CustomerService();
            pagingObject = customerService.getListCustomerBusiness(pagingObject, "");


            List<CustomerBusinessModel> list = pagingObject.getObjects();
            for (CustomerBusinessModel customer : list) {
                System.out.println(customer.getCustomerName() + ": " + customer.getContactName());
            }
            model.addObject("pagingObject", pagingObject);
            return model;

        } else {
            ModelAndView model = new ModelAndView("login");
            String errorLogin = "Username or password is incorrect";
            model.addObject("errorLogin", errorLogin);
            return model;
        }
    }

    @RequestMapping("/gotoLogin")
    public String login() {
        return "login";
    }
}
