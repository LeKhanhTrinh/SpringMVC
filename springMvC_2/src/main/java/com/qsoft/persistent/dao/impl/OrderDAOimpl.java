package com.qsoft.persistent.dao.impl;

import com.qsoft.persistent.dao.OrderDAO;
import com.qsoft.persistent.entity.*;
import com.qsoft.util.DBUtil;
import com.qsoft.util.PagingObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 4/11/14.
 */
public class OrderDAOimpl implements OrderDAO {
    @Override
    // this function use to show list Order in a customer
    public PagingObject<Order> getListOrdersDAO(PagingObject<Order> pagingObject, Customer customer) {

        PagingObject<Order> orderPagingObject = new PagingObject<Order>();
        orderPagingObject.setCurrentPage(pagingObject.getCurrentPage());
        orderPagingObject.setSizeOfPage(pagingObject.getSizeOfPage());

        // getList Order
        int totalRow = 0;
        List<Order> orderList = new ArrayList<Order>();
            Connection conn = null;
            String sql = "select customers.customerNumber, orders.orderNumber, contacts.contactNumber, orders.creationDate, orders.updateDate\n" +
                    "from orders\n" +
                    "inner join orderdetails on orders.orderNumber = orderdetails.orderNumber\n" +
                    "inner join contacts on orders.contactNumber = contacts.contactNumber\n" +
                    "inner join customers on customers.customerNumber = contacts.customerNumber\n" +
                    "where customers.customerNumber = 1\n" +
                    "group by orders.orderNumber;";
            try {
                conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    totalRow++;
                    if ((totalRow >= pagingObject.getCurrentPage() * pagingObject.getSizeOfPage() - (pagingObject.getSizeOfPage() - 1))
                            && totalRow <= ( pagingObject.getCurrentPage() * pagingObject.getSizeOfPage()))
                    orderList.add(new Order(
                                rs.getInt("orderNumber"), new Contact(rs.getInt("contactNumber")),
                                customer, rs.getDate("creationDate"), rs.getDate("updateDate")));
                }
                rs.close();
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);

            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                    }
                }
            }
            int totalPage = totalRow / pagingObject.getSizeOfPage();
            long remainder = totalRow % pagingObject.getSizeOfPage();
            if (remainder != 0L) {
                totalPage++;
            }
            if (totalPage == 0)
                orderPagingObject.setObjects(null);
            else
                orderPagingObject.setObjects(orderList);
            orderPagingObject.setTotalPage(totalPage);

        return orderPagingObject;
    }

    List<Contact> getListContactByCustomer(Customer customer) {
        Connection conn = null;
        String sql = "Select * from  contacts where customerNumber = '" + customer.getId() + "'";
        List<Contact> contactList = new ArrayList<Contact>();
        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                contactList.add( new Contact(customer,
                        rs.getString("contactName"),
                        rs.getString("phone"), rs.getString("email"),
                        rs.getString("jobTitle"), rs.getBoolean("isMain")
                        ));
            }
            rs.close();
            ps.close();
            return  contactList;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }

    }

    @Override
    public String findContactName(Customer customer) {
        Connection conn = null;
        String sql = "Select * from  contacts where isMain = 1 and customerNumber = '" + customer.getId() + "'";
        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            String contactName = "";
            if(rs.next()){
                contactName = rs.getString(3);
            }
            return contactName;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public int getTotalAmount(int orderNumber){

        Connection conn = null;
        String sql = "select orders.orderNumber, SUM(orderdetails.priceEach*orderdetails.quantityOrdered) as Total_Amount"
        + " from orders"
        + " inner join orderdetails on orders.orderNumber = orderdetails.orderNumber"
        + " where orders.orderNumber = " + orderNumber
        + " group by orders.orderNumber;";

        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            int totalAmount = 0;
            if(rs.next()){
                totalAmount = rs.getInt(2);
            }
            return totalAmount;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public List<OrderDetail> getListOrderDetailFromOrder(Order order) {
        int orderId = order.getOrderNumber();
        Connection conn = null;
        String sqlGetListOrderDetail = "Select * from orderdetails where ordernumber = '" +orderId+"'";

        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sqlGetListOrderDetail);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrder(new Order(rs.getInt("orderNumber")));
                orderDetail.setProduct(new Product(rs.getString("serial")));
                orderDetail.setQuantityOrdered(rs.getInt("quantityOrdered"));
                orderDetail.setPriceEach(rs.getDouble("priceEach"));
                orderDetailList.add(orderDetail);
            }
            return orderDetailList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAOimpl();
        List<OrderDetail> orderDetailList = orderDAO.getListOrderDetailFromOrder(new Order(1));
        for (OrderDetail order : orderDetailList) {
            System.out.println(order.getOrder().getOrderNumber() + ": " + order.getQuantityOrdered() + ": "
                    + order.getPriceEach());
        }
    }
}
