package com.qsoft.business.service;

import com.qsoft.business.model.ContactBusinessModel;
import com.qsoft.persistent.dao.ContactDAO;
import com.qsoft.persistent.dao.impl.ContactDAOimpl;
import com.qsoft.persistent.entity.Contact;

/**
 * Created by hunglv on 4/12/14.
 */
public class ContactService {
    public boolean inserContact(ContactBusinessModel contactBusinessModel){
        ContactDAO contactDAO = new ContactDAOimpl();
        Contact contact = new Contact(
                contactBusinessModel.getCustomer(), contactBusinessModel.getContactName(),
                contactBusinessModel.getPhone(), contactBusinessModel.getEmail(),
                contactBusinessModel.getJobTitle(), contactBusinessModel.isMain());

        return contactDAO.insertContact(contact);
    }

}
