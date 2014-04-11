package com.qsoft.persistent.dao.impl;

import com.qsoft.persistent.dao.CustomerDAO;
import com.qsoft.persistent.entity.Customer;
import com.qsoft.util.DBUtil;
import com.qsoft.util.PagingObject;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunglv on 4/10/14.
 */
public class CustomerDAOimpl extends JdbcDaoSupport implements CustomerDAO {

    @Override
    public PagingObject<Customer> getListCustomerDAO(PagingObject<Customer> pagingObject, String criteria) {
        PagingObject<Customer> customerPagingObject = new PagingObject<Customer>();
        customerPagingObject.setCurrentPage(pagingObject.getCurrentPage());
        customerPagingObject.setSizeOfPage(pagingObject.getSizeOfPage());

        // get List of Customer
        Connection conn = null;
        String sql = "Select * from  customers"; // bonus criteria...
        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int totalRow = 0;
            List<Customer> customerList = new ArrayList<Customer>();
            while (rs.next()) {
                totalRow++;
                if ((totalRow >= pagingObject.getCurrentPage() * pagingObject.getSizeOfPage() - (pagingObject.getSizeOfPage() - 1))
                        && totalRow <= ( pagingObject.getCurrentPage() * pagingObject.getSizeOfPage()))
                    customerList.add(new Customer(
                            rs.getInt("customerNumber"), rs.getString("customerName"),
                            rs.getString("avataLink"), rs.getString("phone"),
                            rs.getString("address"), rs.getString("fax"),
                            rs.getString("emailCustomer"), findContactName(rs.getInt("customerNumber"))));
            }
            // compute total of Page
            int totalPage = totalRow / pagingObject.getSizeOfPage();
            long remainder = totalRow % pagingObject.getSizeOfPage();
            if (remainder != 0L) {
                totalPage++;
            }
            if (totalPage == 0)
                customerPagingObject.setObjects(null);
            else
                customerPagingObject.setObjects(customerList);

            customerPagingObject.setTotalPage(totalPage);
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
        return customerPagingObject;
    }

    @Override
    public String findContactName(int customerID) {
        Connection conn = null;
        String sql = "Select * from  contacts where isMain = 1 and customerNumber = '" + customerID + "'";
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
        }
    }
}
