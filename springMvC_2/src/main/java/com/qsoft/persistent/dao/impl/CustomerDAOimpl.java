package com.qsoft.persistent.dao.impl;

import com.qsoft.persistent.dao.CustomerDAO;
import com.qsoft.persistent.entity.Contact;
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
        String sql = "Select * from  customers where customerName like \'%" + criteria + "%\';";
        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int totalRow = 0;
            List<Customer> customerList = new ArrayList<Customer>();
            while (rs.next()) {
                totalRow++;
                if ((totalRow >= pagingObject.getCurrentPage() * pagingObject.getSizeOfPage() - (pagingObject.getSizeOfPage() - 1))
                        && totalRow <= (pagingObject.getCurrentPage() * pagingObject.getSizeOfPage()))
                    customerList.add(new Customer(
                            rs.getInt("customerNumber"), rs.getString("customerName"),
                            rs.getString("avataLink"), rs.getString("phone"),
                            rs.getString("address"), rs.getString("fax"),
                            rs.getString("emailCustomer")));
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
    public String findContactName(Customer customer) {
        Connection conn = null;
        String sql = "Select * from  contacts where isMain = 1 and customerNumber = '" + customer.getId() + "'";
        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            String contactName = "";
            if (rs.next()) {
                contactName = rs.getString(3);
            }
            return contactName;
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
    public int getTotalEquipment(Customer customer) {

        Connection conn = null;

        String sql = "select customers.customerNumber, SUM(orderdetails.quantityOrdered) as totalEquipment"
                + " from customers"
                + " inner join contacts on customers.customerNumber = contacts.customerNumber"
                + " inner join orders on contacts.contactNumber = orders.contactNumber"
                + " inner join orderdetails on orders.orderNumber = orderdetails.orderNumber"
                + " WHERE customers.customerNumber = " + customer.getId()
                + " group by customerNumber;";

        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            int totalEquipment = 0;
            if (rs.next()) {
                totalEquipment = rs.getInt(2);
            }
            return totalEquipment;
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
    public String getLatestOrder(Customer customer) {

        Connection conn = null;

        String sql = "select customers.customerNumber, MAX(orders.updateDate) as latest, orders.orderNumber"
                + " from customers"
                + " inner join contacts on customers.customerNumber = contacts.customerNumber"
                + " inner join orders on contacts.contactNumber = orders.contactNumber"
                + " WHERE customers.customerNumber = " + customer.getId()
                + " GROUP BY customerNumber;";

        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            String contactName = "";
            if (rs.next()) {
                contactName = rs.getString(3);
            }
            return contactName;
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
    public Customer findCustomerByName(String customerName) {
        Customer tempCustomer = new Customer();

        Connection conn = null;

        String sql = "select * from customers where customerName = \'" + customerName + "\';";

        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                tempCustomer = new Customer(
                        rs.getInt("customerNumber"), rs.getString("customerName"),
                        rs.getString("avataLink"), rs.getString("phone"),
                        rs.getString("address"), rs.getString("fax"),
                        rs.getString("emailCustomer"));
            }

            return tempCustomer;
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
    public Customer findDetailByCustomerId(int idCustomer) {

        Customer tempCustomer = new Customer();
        Connection conn = null;

        String sql = "select * from customers where customerNumber = \'" + idCustomer + "\';";

        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tempCustomer = new Customer(
                        rs.getInt("customerNumber"), rs.getString("customerName"),
                        rs.getString("avataLink"), rs.getString("phone"),
                        rs.getString("address"), rs.getString("fax"),
                        rs.getString("emailCustomer"));
            }

            return tempCustomer;
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
    public Contact findContactByCustomer(Customer customer) {
        Connection conn = null;
        Contact tempContact = null;

        String sql = "Select * from  contacts where isMain = 1 and customerNumber = '" + customer.getId() + "'";
        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tempContact = new Contact(
                        rs.getInt("contactNumber"),
                        rs.getString("contactName"), rs.getString("phone"),
                        rs.getString("email"), rs.getString("jobTitle"),
                        rs.getBoolean("isMain"));
            }
            return tempContact;
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
}
