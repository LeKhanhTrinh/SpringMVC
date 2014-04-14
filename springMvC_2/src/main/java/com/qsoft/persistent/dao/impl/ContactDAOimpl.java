package com.qsoft.persistent.dao.impl;

import com.qsoft.persistent.dao.ContactDAO;
import com.qsoft.persistent.entity.Contact;
import com.qsoft.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by hunglv on 4/12/14.
 */
public class ContactDAOimpl implements ContactDAO {
    public boolean insertContact(Contact contact) {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();

            String insert = "INSERT INTO contacts (customerNumber, contactName, phone, email, jobTitle, isMain) " +
                    "VALUES(?, ?, ?, ?, ?, ?)";

            PreparedStatement psmt = conn.prepareStatement(insert);

            psmt.setInt(1, contact.getCustomer().getId());
            psmt.setString(2, contact.getContactName());
            psmt.setString(3, contact.getPhone());
            psmt.setString(4, contact.getEmail());
            psmt.setString(5, contact.getJobTitle());
            psmt.setBoolean(6, contact.isMain());

            // then execute the batch
            conn.setAutoCommit(false);
            psmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);

            psmt.close();
            conn.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
