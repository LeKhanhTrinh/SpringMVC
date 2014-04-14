package com.qsoft.persistent.dao;


import com.qsoft.persistent.entity.Customer;
import com.qsoft.persistent.entity.Product;
import com.qsoft.util.PagingObject;

public interface EquipmentDAO {
    PagingObject<Product> getListEquipmentDAO(PagingObject<Product> pagingObjects, Customer customer);

    public Product findProductByIdProduct(String serialProduct);
}
