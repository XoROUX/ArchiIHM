package com.wheretact.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.wheretact.business.WhereTactWebDAOFactory;
import com.wheretact.controller.WhereTactServiceInterface;
import com.wheretact.models.Contact;

/**
 * Pseudo-Servcice class that is to be called by the controllers in order to access contact information. 
 * @author Pierre
 *
 */
public class ContactService implements WhereTactServiceInterface<Contact> {

	public ContactService() {  }

	@Override
	public int createObject(Contact myObject) {
		return WhereTactWebDAOFactory.getContactDAO().createObject(myObject);
	}

	@Override
	public int deleteObject(UUID objectId) {
		return WhereTactWebDAOFactory.getContactDAO().deleteObject(objectId);
	}

	@Override
	public int updateObject(Contact myNewObj) {
		return WhereTactWebDAOFactory.getContactDAO().updateObject(myNewObj);
	}

	@Override
	public ArrayList<Contact> readAll() {
		return (ArrayList<Contact>) WhereTactWebDAOFactory.getContactDAO().readAll();
	}

	@Override
	public HashMap<UUID, Contact> getMapping() {
		return WhereTactWebDAOFactory.getContactDAO().getMapping();
	}

	@Override
	public Contact getObjByID(UUID objectId) {
		return WhereTactWebDAOFactory.getContactDAO().getObjByID(objectId);
	}

}
