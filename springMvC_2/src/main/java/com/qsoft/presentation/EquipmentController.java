package com.qsoft.presentation;

import com.qsoft.business.model.EquipmentBusinessModel;
import com.qsoft.business.service.EquipmentService;
import com.qsoft.persistent.entity.Customer;
import com.qsoft.util.PagingObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EquipmentController {
    @RequestMapping(value = "/equipment", method= RequestMethod.GET)
    public ModelAndView goEquipmentFirst( @RequestParam("customer") String customerID) {
        ModelAndView modelAndView = new ModelAndView("ListEquipment");

        PagingObject<EquipmentBusinessModel> equipmentBusinessModelPagingObject = new PagingObject<EquipmentBusinessModel>();
        equipmentBusinessModelPagingObject.setCurrentPage(1);
        equipmentBusinessModelPagingObject.setSizeOfPage(5);

        int idCustomer = Integer.parseInt(customerID);
        Customer customer = new Customer(idCustomer);
        EquipmentService equipmentService = new EquipmentService();
        equipmentBusinessModelPagingObject = equipmentService.getListEquipmentBusinessModel(
                equipmentBusinessModelPagingObject, customer);

        modelAndView.addObject("customerId", customerID);
        modelAndView.addObject("pagingObject", equipmentBusinessModelPagingObject);

        for(EquipmentBusinessModel model : equipmentBusinessModelPagingObject.getObjects()){
            System.out.println(model.getSerialProduct());
        }

        System.out.println("CurrentPage" + equipmentBusinessModelPagingObject.getCurrentPage()
        + "Total Page" + equipmentBusinessModelPagingObject.getTotalPage());
        return modelAndView;
    }

    @RequestMapping(value = "/equipmentList", method= RequestMethod.POST)
    public ModelAndView goEquipmentMore( @RequestParam("customer") String customerID,
                                         @RequestParam ("currentPage") String currentPage) {

        ModelAndView modelAndView = new ModelAndView("ListEquipment");

        PagingObject<EquipmentBusinessModel> equipmentBusinessModelPagingObject =
                new PagingObject<EquipmentBusinessModel>();
        equipmentBusinessModelPagingObject.setCurrentPage(Integer.parseInt(currentPage));
        equipmentBusinessModelPagingObject.setSizeOfPage(5);
        int idCustomer = Integer.parseInt(customerID);
        Customer customer = new Customer(idCustomer);
        EquipmentService equipmentService = new EquipmentService();
        equipmentBusinessModelPagingObject =
                equipmentService.getListEquipmentBusinessModel(equipmentBusinessModelPagingObject, customer);

        modelAndView.addObject("customerId", customerID);
        modelAndView.addObject("pagingObject", equipmentBusinessModelPagingObject);
        return modelAndView;
    }
}
