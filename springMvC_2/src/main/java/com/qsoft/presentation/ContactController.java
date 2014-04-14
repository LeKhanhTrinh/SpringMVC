package com.qsoft.presentation;

import com.qsoft.business.model.ContactBusinessModel;
import com.qsoft.business.service.ContactService;
import com.qsoft.persistent.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
    @RequestMapping(value = "/goAddContact", method=RequestMethod.GET)
    public ModelAndView goAddContact( @RequestParam("customer") String customerID) {
        ModelAndView modelAndView = new ModelAndView("addContact");
        modelAndView.addObject("confirm", 0);
        modelAndView.addObject("customerId", customerID);
        return modelAndView;
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public ModelAndView addContact(@RequestParam(value = "nameContact") String nameContact,
                                   @RequestParam(value = "phoneContact") String phoneContact,
                                   @RequestParam(value = "mailContact") String mailContact,
                                   @RequestParam(value = "jobTitle") String jobTitle,
                                   @RequestParam(value = "isMain") boolean isMain,
                                   @RequestParam(value = "customerId") int customerId){

        ModelAndView modelAndView = new ModelAndView("addContact");

        Customer customer = new Customer(customerId);
        ContactBusinessModel contactBusinessModel = new ContactBusinessModel(
                customer, nameContact, phoneContact, mailContact, jobTitle, isMain);


        ContactService  contactService = new ContactService();
        if (contactService.inserContact(contactBusinessModel)){
            modelAndView.addObject("confirm", 1);
            modelAndView.addObject("customerId", customerId);
        }
        return  modelAndView;
    }
}
