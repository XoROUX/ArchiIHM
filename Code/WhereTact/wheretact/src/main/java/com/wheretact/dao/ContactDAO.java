package com.wheretact.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.wheretact.business.WhereTactWebDAOInterface;
import com.wheretact.models.Contact;


/***
 * TO DO : 
 * 		-	Attributs ContactDAO - OK
 * 		-	Constructeur en singleton - OK
 * 		-	Getters - OK
 * 		-	Setters - OK
 * 		-	Create - OK
 * 		-	Read
 * 				ALL  - OK
 * 				HMap - OK
 * 				byId - OK
 * 		-	Update - OK
 * 		-	Delete - OK
 */

/**
 * Class ContactDAO : Singleton class that manages all the contacts we will use
 * @author Pierre
 *
 */
public class ContactDAO implements WhereTactWebDAOInterface<Contact> {

	private static ContactDAO instance = null; 
	private HashMap<UUID, Contact> allContacts;
	
	/**
	 * @Constructor
	 */
	private ContactDAO() {
		this.allContacts = new HashMap<UUID, Contact>();
		start();
	}
	
	/**
	 * Singleton that ensures the use of the same DAO and data
	 */
	public static ContactDAO getInstance(){
		if(instance == null){
			instance = new ContactDAO();
			System.out.println("\n\n___________<<< NEW ContactDAO !!! >>>___________\n"+
					instance.toString()+"\n_______________________________________________\n\n");
		}
		else{
			System.out.println("\n\n___________<<< single ContactDAO >>>___________\n"+
					instance.toString()+"\n_______________________________________________\n\n");
		}
		return instance;
	}
	
	@Override
	public void start() {

		Contact sampleContact = null;
		for(int i=0; i<5; i++){
			sampleContact = new Contact(UUID.randomUUID(), "birthdate", "email", "firstname", "lastname", i, null, null);
			
			createObject(sampleContact);
			System.out.println("STARTING : CONTACT ---> " + sampleContact.toString()+"___________________");
		}
		
	}

	/**
	 * Creates a contact
	 */
	@Override
	public int createObject(Contact myObject) {
		try{
			if(allContacts.containsKey(myObject.getContactId())){
				return 1; 
			}
			allContacts.put(myObject.getContactId(), myObject);
			return 0;
			
		}catch(Exception e){
			return 2;
		}
	}

	/**
	 * Delete a contact
	 */
	@Override
	public int deleteObject(UUID objectId) {
		try{
			if(allContacts.containsKey(objectId.toString())){
				allContacts.remove(objectId.toString());
				return 0;
			}
			
			return 1;
		}catch(Exception e){
			return 2;
		}
	}

	/**
	 * Update a contact
	 */
	@Override
	public int updateObject(Contact myNewObj) {
		try {
			if(allContacts.containsKey(myNewObj.getContactId())){
				allContacts.put(myNewObj.getContactId(), myNewObj);
				return 0;
			}
			return 1;
		}catch(Exception e){
			
			return 2;
		}
		
		
	}

	/**
	 * Read all contacts as a list
	 */
	@Override
	public List<Contact> readAll() {
		try{
			if(allContacts == null){
				System.out.println("RAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
				return new ArrayList<Contact>();
			}
			System.out.println("\n\n[ContactDAO][readAll] ******* "+allContacts.values()+"\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n\n");
			return (ArrayList<Contact>) allContacts.values();
		}catch(Exception e){
			return new ArrayList<Contact>();
		}
		
	}

	/**
	 * Get the HashMap of contacts
	 */
	@Override
	public HashMap<UUID, Contact> getMapping() {
		try {
			return allContacts;
		}catch(Exception e){
			return new HashMap<UUID, Contact>();
		}
	}
	
	/**
	 * Get an address using it's contactId
	 */
	@Override
	public Contact getObjByID(UUID objectId) {
		try {
			if(allContacts.containsKey(objectId)){
				return allContacts.get(objectId);
			}
			return null;
		}catch(Exception e){
			return null;
		}
	}

}
