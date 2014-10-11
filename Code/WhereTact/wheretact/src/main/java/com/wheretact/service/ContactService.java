package com.wheretact.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.wheretact.business.WhereTactWebDAOFactory;
import com.wheretact.business.WhereTactWebDAOInterface;
import com.wheretact.controller.WhereTactServiceInterface;
import com.wheretact.models.Contact;

/**
 * Pseudo-Servcice class that is to be called by the controllers in order to access contact information. 
 * @author Pierre
 *
 */
public class ContactService implements WhereTactServiceInterface<Contact> {

	private WhereTactWebDAOInterface<Contact> myDAO = null;
	public ContactService() {
		this.myDAO = WhereTactWebDAOFactory.getContactDAO();
		
		if(this.myDAO.getMapping().size() == 0){
			System.out.println("\n\n\n_____________________________\n[ContactService][ContactService] : ELEMENTS NOT RECIEVED HERE !!!!\n\n_______________________\n\n");
		}
		else{
			System.out.println("\n\n\n_____________________________\n[ContactService][ContactService] : ELEMENTS RECIEVED HERE  COUNT : "+this.myDAO.getMapping().size()+"!!!!\n\n_______________________\n\n");
		}
	}

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
		//ArrayList<Contact> myArray = (ArrayList<Contact>) WhereTactWebDAOFactory.getContactDAO().readAll();
		
		if(this.myDAO.getMapping().size() == 0){
			System.out.println("\n\n\n_____________________________\n [ContactService][readAll] : ELEMENTS NOT RECIEVED HERE !!!!\n\n_______________________\n\n");
		}
		else{
			System.out.println("\n\n\n_____________________________\n[ContactService][readAll] : ELEMENTS RECIEVED HERE  COUNT : "+this.myDAO.getMapping().size()+"!!!!\n\n_______________________\n\n");
		}
		
		ArrayList<Contact> myArray = (ArrayList<Contact>) myDAO.readAll();
		System.out.println("\n_________________________________\n\nBOBOOBOBOBOBOOOOOBOBOBOBOBOBOBOBOBOBOBOBOBOO\nmyListLength : "
		+myArray.size()+"__________________\n\n");
		for(Contact c : myArray){
			System.out.println("\n____________\n"+c.toString()+"\n\n");
		}
		return myArray;
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
