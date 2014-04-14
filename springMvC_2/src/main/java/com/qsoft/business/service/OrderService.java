package com.qsoft.business.service;

import com.qsoft.business.model.OrderListBusinessModel;
import com.qsoft.persistent.dao.CustomerDAO;
import com.qsoft.persistent.dao.OrderDAO;
import com.qsoft.persistent.dao.impl.CustomerDAOimpl;
import com.qsoft.persistent.dao.impl.OrderDAOimpl;
import com.qsoft.persistent.entity.Customer;
import com.qsoft.persistent.entity.Order;
import com.qsoft.util.PagingObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Master on 4/13/14.
 */
public class OrderService {

    public PagingObject<OrderListBusinessModel> getListOrderBusinessModel(
            PagingObject<OrderListBusinessModel> pagingObject, Customer customer){

        PagingObject<Order> orderPagingObject = new PagingObject<Order>();
        orderPagingObject.setCurrentPage(pagingObject.getCurrentPage());
        orderPagingObject.setSizeOfPage(pagingObject.getSizeOfPage());

        //get pagingObject<Order>
        OrderDAO orderDAOimpl = new OrderDAOimpl();
        orderPagingObject = orderDAOimpl.getListOrdersDAO(orderPagingObject, customer);

        // convert orderList to orderListBusinessModelList....
        List<Order> orderList = orderPagingObject.getObjects();
        PagingObject<OrderListBusinessModel> orderListBusinessModelPagingObject = new PagingObject<OrderListBusinessModel>();

        //set values for pagingObject
        orderListBusinessModelPagingObject.setCurrentPage(orderPagingObject.getCurrentPage());
        orderListBusinessModelPagingObject.setSizeOfPage(orderPagingObject.getSizeOfPage());
        orderListBusinessModelPagingObject.setTotalPage(orderPagingObject.getTotalPage());
        orderListBusinessModelPagingObject.setObjects(getListOrderListBusinessModelFromOrderList(orderList,customer));

        return orderListBusinessModelPagingObject;

    }

    List<OrderListBusinessModel> getListOrderListBusinessModelFromOrderList(List<Order> orderList, Customer customer){

        List<OrderListBusinessModel> orderListBusinessModelList = new ArrayList<OrderListBusinessModel>();
        for (Order order : orderList){
            OrderListBusinessModel orderListBusinessModel = new OrderListBusinessModel();
            CustomerDAO customerDAO = new CustomerDAOimpl();
            OrderDAO orderDAO = new OrderDAOimpl();

            orderListBusinessModel.setContactName(customerDAO.findContactName(customer));
            orderListBusinessModel.setTotalAmount(orderDAO.getTotalAmount(order.getOrderNumber()));
            orderListBusinessModel.setOrderNumber(order.getOrderNumber());
            orderListBusinessModel.setCreationDate(order.getCreationDate());
            orderListBusinessModel.setUpdateDate(order.getUpdatedDate());

            orderListBusinessModelList.add(orderListBusinessModel);
        }

        return orderListBusinessModelList;
    }

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        PagingObject<OrderListBusinessModel> orderListBusinessModelPagingObject = new PagingObject<OrderListBusinessModel>();
        orderListBusinessModelPagingObject.setCurrentPage(1);
        orderListBusinessModelPagingObject.setSizeOfPage(5);
        Customer customer = new Customer(3);
        orderListBusinessModelPagingObject = orderService.getListOrderBusinessModel(orderListBusinessModelPagingObject, customer);

        for(OrderListBusinessModel orderListBusinessModel : orderListBusinessModelPagingObject.getObjects()){
            System.out.println(orderListBusinessModel.getOrderNumber() +":"+orderListBusinessModel.getContactName()
                    +": "+ orderListBusinessModel.getTotalAmount() + ":" + orderListBusinessModel.getCreationDate());
        }
    }
}
