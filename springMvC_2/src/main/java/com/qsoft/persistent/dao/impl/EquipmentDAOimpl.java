package com.qsoft.persistent.dao.impl;

import com.qsoft.persistent.dao.EquipmentDAO;
import com.qsoft.persistent.entity.Customer;
import com.qsoft.persistent.entity.Product;
import com.qsoft.persistent.entity.ProductLine;
import com.qsoft.util.DBUtil;
import com.qsoft.util.PagingObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 4/13/14.
 */
public class EquipmentDAOimpl implements EquipmentDAO {
    @Override
    public PagingObject<Product> getListEquipmentDAO(PagingObject<Product> pagingObjects, Customer customer) {
        PagingObject<Product> productPagingObject = new PagingObject<Product>();
        productPagingObject.setCurrentPage(pagingObjects.getCurrentPage());
        productPagingObject.setSizeOfPage(pagingObjects.getSizeOfPage());

        // get List of Equipment
        Connection conn = null;
        String sql = "select customers.customerNumber, products.serial, productlines.name,  products.model, products.years\n" +
                "from products\n" +
                "inner join productlines on productlines.idProductLine = products.idProductLine\n" +
                "inner join orderdetails on orderdetails.serial = products.serial\n" +
                "inner join orders on orders.orderNumber = orderdetails.orderNumber\n" +
                "inner join contacts on orders.contactNumber = contacts.contactNumber\n" +
                "inner join customers on customers.customerNumber = contacts.customerNumber\n" +
                "where customers.customerNumber = '" + customer.getId() + "'";
        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int totalRow = 0;
            List<Product> productList = new ArrayList<Product>();
            while (rs.next()) {
                totalRow++;
                if ((totalRow >= pagingObjects.getCurrentPage() * pagingObjects.getSizeOfPage() - (pagingObjects.getSizeOfPage() - 1))
                        && totalRow <= (pagingObjects.getCurrentPage() * pagingObjects.getSizeOfPage()))
                    productList.add(new Product(rs.getString("serial"), new ProductLine(rs.getString("name")),
                            rs.getString("model"), rs.getInt("years")));
            }
            // compute total of Page
            int totalPage = totalRow / pagingObjects.getSizeOfPage();
            long remainder = totalRow % pagingObjects.getSizeOfPage();
            if (remainder != 0L) {
                totalPage++;
            }
            if (totalPage == 0)
                productPagingObject.setObjects(null);
            else
                productPagingObject.setObjects(productList);

            productPagingObject.setTotalPage(totalPage);
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
        return productPagingObject;
    }

    @Override
    public Product findProductByIdProduct(String serialProduct) {
        Customer tempCustomer = new Customer();

        Connection conn = null;

        String sql = "select * from products where serial = \'" + serialProduct + "\';";

        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                Product product = new Product(serialProduct, new ProductLine(rs.getString("idProductLine")),
                        rs.getString("model"), rs.getInt("years"));
                return product;
            }
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
        return null;
    }
}