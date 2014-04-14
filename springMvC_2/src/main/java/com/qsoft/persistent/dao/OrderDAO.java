package com.qsoft.persistent.dao;

import com.qsoft.persistent.entity.Customer;
import com.qsoft.persistent.entity.Order;
import com.qsoft.persistent.entity.OrderDetail;
import com.qsoft.util.PagingObject;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 4/11/14.
 */
public interface OrderDAO {
    // List<OrderDetail> getListOrderDetailsByOrder(Order order);
    PagingObject<Order> getListOrdersDAO(PagingObject<Order> orderPagingObject, Customer customer);

    String findContactName(Customer customer);

    int getTotalAmount(int orderNumber);

    Order getOrderFromId(int id);

    Date getCreationDateFromId(int id);

    List<OrderDetail> getListOrderDetailFromOrder(Order order);
}
