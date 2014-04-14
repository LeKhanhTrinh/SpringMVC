package com.qsoft.business.service;

import com.qsoft.business.model.EquipmentBusinessModel;
import com.qsoft.persistent.dao.EquipmentDAO;
import com.qsoft.persistent.dao.impl.EquipmentDAOimpl;
import com.qsoft.persistent.entity.Customer;
import com.qsoft.persistent.entity.Product;
import com.qsoft.util.PagingObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 4/13/14.
 */
public class EquipmentService {
    public PagingObject<EquipmentBusinessModel> getListEquipmentBusinessModel(
            PagingObject<EquipmentBusinessModel> pagingObject, Customer customer){

        PagingObject<Product> productPagingObject = new PagingObject<Product>();
        productPagingObject.setCurrentPage(pagingObject.getCurrentPage());
        productPagingObject.setSizeOfPage(pagingObject.getSizeOfPage());
        EquipmentDAO equipmentDAO = new EquipmentDAOimpl();
        productPagingObject = equipmentDAO.getListEquipmentDAO(productPagingObject, customer);

        List<Product> productList = productPagingObject.getObjects();
        PagingObject<EquipmentBusinessModel> equipmentBusinessModelPagingObject = new PagingObject<EquipmentBusinessModel>();
        equipmentBusinessModelPagingObject.setCurrentPage(productPagingObject.getCurrentPage());
        equipmentBusinessModelPagingObject.setTotalPage(productPagingObject.getTotalPage());
        equipmentBusinessModelPagingObject.setSizeOfPage(productPagingObject.getSizeOfPage());
        equipmentBusinessModelPagingObject.setObjects(getListEquipmentBusinessModelFromListProduct(productList));

        return equipmentBusinessModelPagingObject;
    }

    List<EquipmentBusinessModel> getListEquipmentBusinessModelFromListProduct(List<Product> productList){
        List<EquipmentBusinessModel> equipmentBusinessModelList = new ArrayList<EquipmentBusinessModel>();
        for(Product product : productList){
            EquipmentBusinessModel equipmentBusinessModel = new EquipmentBusinessModel(
                    product.getSerialProduct(), product.getProductLine(),
                    product.getModelProduct(), product.getYear());
            equipmentBusinessModelList.add(equipmentBusinessModel);
        }
        return equipmentBusinessModelList;
    }

    public static void main(String[] args) {
        EquipmentService equipmentService = new EquipmentService();
        PagingObject<EquipmentBusinessModel> equipmentBusinessModelPagingObject = new PagingObject<EquipmentBusinessModel>();
        equipmentBusinessModelPagingObject.setCurrentPage(1);
        equipmentBusinessModelPagingObject.setSizeOfPage(5);
        Customer customer = new Customer(1);
        equipmentBusinessModelPagingObject = equipmentService.getListEquipmentBusinessModel(equipmentBusinessModelPagingObject, customer);
        System.out.println(equipmentBusinessModelPagingObject.getTotalPage());
        for(EquipmentBusinessModel product : equipmentBusinessModelPagingObject.getObjects()){
            System.out.println(product.getSerialProduct() +":"+product.getProductLine().getName()
                    +": "+ product.getModelProduct() + ":" + product.getYear());
        }
    }
}
