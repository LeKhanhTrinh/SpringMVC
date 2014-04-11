package com.qsoft.persistent.dao.impl;

import com.qsoft.persistent.dao.OrderDAO;
import com.qsoft.persistent.entity.Contact;
import com.qsoft.persistent.entity.Customer;
import com.qsoft.persistent.entity.Order;
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
        orderPagingObject.setCurrentPage(orderPagingObject.getCurrentPage());
        orderPagingObject.setSizeOfPage(orderPagingObject.getSizeOfPage());

        // getList Order
        int totalRow = 0;
        List<Order> orderList = new ArrayList<Order>();
        for(Contact contact: getListContactByCustomer(customer)){
            Connection conn = null;
            String sql = "Select * from  orders where contactNumber = '" + contact.getContactNumber() + "'" +
                    " ORDER BY updateDate DESC";
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
        }
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
                contactList.add( new Contact(
                        rs.getInt("contactNumber"), customer,
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

    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAOimpl();
        PagingObject<Order> pagingObject = new PagingObject<Order>();
        pagingObject.setCurrentPage(1);
        pagingObject.setSizeOfPage(5);
        Customer customer = new Customer(1);
        pagingObject = orderDAO.getListOrdersDAO(pagingObject, customer);

        for (Order order : pagingObject.getObjects()) {
            System.out.println(order.getOrderNumber() + ": " + order.getContact().getContactNumber() + ": "
                    + customer.getId());
        }
    }
}
