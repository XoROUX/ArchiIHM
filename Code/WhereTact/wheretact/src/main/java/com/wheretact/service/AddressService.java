package com.wheretact.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.wheretact.business.WhereTactWebDAOFactory;
import com.wheretact.controller.WhereTactServiceInterface;
import com.wheretact.models.Address;

/**
 * Pseudo-Servcice class that is to be called by the controllers in order to access address information. 
 * @author Pierre
 *
 */
public class AddressService implements WhereTactServiceInterface<Address> {
	
	public AddressService() {
	}

	@Override
	public int createObject(Address myObject) {
		return WhereTactWebDAOFactory.getAddressDAO().createObject(myObject);
	}

	@Override
	public int deleteObject(UUID objectId) {
		return WhereTactWebDAOFactory.getAddressDAO().deleteObject(objectId);
	}

	@Override
	public int updateObject(Address myNewObj) {
		return WhereTactWebDAOFactory.getAddressDAO().updateObject(myNewObj);
	}

	@Override
	public ArrayList<Address> readAll() {
		return (ArrayList<Address>) WhereTactWebDAOFactory.getAddressDAO().readAll();
	}

	@Override
	public HashMap<UUID, Address> getMapping() {
		return WhereTactWebDAOFactory.getAddressDAO().getMapping();
	}

	@Override
	public Address getObjByID(UUID objectId) {
		return WhereTactWebDAOFactory.getAddressDAO().getObjByID(objectId);
	}

}
