package com.qsoft.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EquipmentController {
    @RequestMapping(value = "/equipment", method= RequestMethod.GET)
    public ModelAndView goEquipment( @RequestParam("customer") String customerID) {
        ModelAndView modelAndView = new ModelAndView("ListEquipment");
        modelAndView.addObject("customerId", customerID);
        return modelAndView;
    }
}
