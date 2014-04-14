package com.qsoft.business.service;

import com.qsoft.business.model.OrderDetailBusinessModel;
import com.qsoft.persistent.dao.EquipmentDAO;
import com.qsoft.persistent.dao.OrderDAO;
import com.qsoft.persistent.dao.impl.EquipmentDAOimpl;
import com.qsoft.persistent.dao.impl.OrderDAOimpl;
import com.qsoft.persistent.entity.Customer;
import com.qsoft.persistent.entity.Order;
import com.qsoft.persistent.entity.OrderDetail;
import com.qsoft.persistent.entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunglv on 4/14/14.
 */
public class OrderDetailService {
    public List<OrderDetailBusinessModel> getListOrderDetailBusinessModel(Customer customer, Order order){

        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        List<OrderDetailBusinessModel> orderDetailBusinessModelList = new ArrayList<OrderDetailBusinessModel>();

        OrderDAO orderDAO = new OrderDAOimpl();
        orderDetailList = orderDAO.getListOrderDetailFromOrder(order);

        for(OrderDetail orderDetail : orderDetailList){
            OrderDetailBusinessModel orderDetailBusinessModel = new OrderDetailBusinessModel();
            EquipmentDAO equipmentDAO = new EquipmentDAOimpl();
            Product product = equipmentDAO.findProductByIdProduct(orderDetail.getProduct().getSerialProduct());

            orderDetailBusinessModel.setProduct(product);
            orderDetailBusinessModel.setPriceEach(orderDetail.getPriceEach());
            orderDetailBusinessModel.setQuantityOrdered(orderDetail.getQuantityOrdered());
            orderDetailBusinessModel.setDescription(product.toString());

            orderDetailBusinessModelList.add(orderDetailBusinessModel);
        }

        return  orderDetailBusinessModelList;
    }

    public double getTotalOrderDetails(List<OrderDetailBusinessModel> orderDetailBusinessModelList){
        double total = 0;
        for (OrderDetailBusinessModel orderDetailBusinessModel : orderDetailBusinessModelList){
            total += orderDetailBusinessModel.getPriceEach()*orderDetailBusinessModel.getQuantityOrdered();
        }
        return total;
    }

    public static void main(String[] args) {
        OrderDetailService orderDetailService = new OrderDetailService();
        List<OrderDetailBusinessModel> orderDetailBusinessModelList =
                orderDetailService.getListOrderDetailBusinessModel(new Customer(1), new Order(1));
        for (OrderDetailBusinessModel orderDetailBusinessModel : orderDetailBusinessModelList){
            System.out.println(orderDetailBusinessModel.getDescription() + ", " + orderDetailBusinessModel.getQuantityOrdered()
            + ", " + orderDetailBusinessModel.getPriceEach());
        }
    }
}
