package com.wheretact.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.wheretact.business.WhereTactWebDAOInterface;
import com.wheretact.models.Address;
import com.wheretact.models.Contact;


/***
 * TO DO : 
 * 		-	Attributs AddressDAO - OK
 * 		-	Constructeur en singleton - OK
 * 		-	Getters - OK
 * 		-	Setters - OK
 * 		-	Create - OK
 * 		-	Read
 * 				ALL  - OK
 * 				byId - OK
 * 				HMap - OK
 * 		-	Update - OK
 * 		-	Delete - OK
 */

/**
 * Class AddressDAO : Singleton class that manages all the addresses we will use
 * @author Pierre Manu
 *
 */
public class AddressDAO implements WhereTactWebDAOInterface<Address> {

	private static AddressDAO instance = null;
	private static HashMap<UUID, Address> allAddresses;
	
	private static ValidatorFactory factory;
	private static Validator validator;
	
	/**
	 * @Constructor
	 */
		private AddressDAO() {
		allAddresses = new HashMap<UUID, Address>();
		factory =Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();	
		start();
	}
		
	
		
		
		
	/**
	 * Singleton that ensures the use of the same DAO and data
	 */
	public static AddressDAO getInstance(){
		if(instance == null){
			instance = new AddressDAO();
		}
		return instance;
	}
	
	/**
	 * Retrieves the addresses from the address file.
	 */
	@Override
	public void start() {
		
		ContactDAO contacts = ContactDAO.getInstance();
		Address newAddress = null;
		
		if(contacts.getMapping().size()>0){
			for(UUID contactId : contacts.getMapping().keySet()){
				try {
					newAddress = new Address(contactId, UUID.randomUUID(), 0, "street", "postCode", "city", "state", "country");
					createObject(newAddress);
				
					linktoContact(contacts.getObjByID(contactId), newAddress, false);
					
					newAddress = new Address(contactId, UUID.randomUUID(), 0, "other", "other", "other", "other", "other");
					createObject(newAddress);
					
					linktoContact(contacts.getObjByID(contactId), newAddress, false);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			/****validate****/ 
			
		}
		
	}
	
	public void linktoContact(Contact c, Address a, boolean asBillingAddress) throws Exception{
		if(c == null || a == null) {
			throw new Exception("Null parameter exception");
		}
		
		a.setContactId(c.getContactId());
		
		if(asBillingAddress){
			c.setBillingAddress(a);
		}
		else {
			c.addContactAddress(a.getAddressId(), a);
		}
	}
	
	public ArrayList<Address> getContactAddresses(UUID contact) {
		ArrayList<Address> resultList = new ArrayList<Address>();
		
		for(Address iterationAddress : allAddresses.values()){
			if(iterationAddress.getContactId().equals(contact)){
				resultList.add(iterationAddress);
			}
		}
		
		return resultList;
	}
	
	/**
	 * Create an address
	 */
	@Override
	public int createObject(Address myObject) {
		
		Set<ConstraintViolation<Address>> constraintViolations = validator.validate(myObject);
		try{
			if(allAddresses.containsKey(myObject.getAddressId())){
				return 1; 
			}
			
			if(constraintViolations.size()> 0 ){
				System.out.println("Impossible de valider votre adresse");
				//for(ConstraintViolation<Address> contrainte : constraintViolations){
				//	System.out.println(contrainte.getRootBeanClass().getSimpleName()+ "." + contrainte.getPropertyPath() + " " + contrainte.getMessage());					
			//	}
				return 1; 
			}
			 else {
						System.out.println("L'adresse est bien enregistrée");
						allAddresses.put(myObject.getAddressId(), myObject);
						return 0;
					}					
		}catch(Exception e){
			return 2;
		}		
			}

	/**
	 * Delete an address
	 */
	@Override
	public int deleteObject(UUID objectId) {
		try{
			if(allAddresses.containsKey(objectId)){
				allAddresses.remove(objectId);
				return 0;
			}
			
			return 1;
		}catch(Exception e){
			return 2;
		}
	}

	/**
	 * Update an address
	 */
	@Override
	public int updateObject(Address myNewObj) {
		try {
			if(allAddresses.containsKey(myNewObj.getAddressId())){
				allAddresses.put(myNewObj.getAddressId(), myNewObj);
				return 0;
			}
			return 1;
		}catch(Exception e){
			
			return 2;
		}
	}

	/**
	 * Read all addresses as a list
	 */
	@Override
	public List<Address> readAll() {
		try{
			if(allAddresses == null){
				return new ArrayList<Address>();
			}
			
			ArrayList<Address> returnList = new ArrayList<Address>();
			for(Address a : allAddresses.values()){
				returnList.add(a);
			}
			return returnList;
		}catch(Exception e){
			return new ArrayList<Address>();
		}
		
	}

	/**
	 * Get the HashMap of addresses
	 */
	@Override
	public HashMap<UUID, Address> getMapping() {
		try {
			return allAddresses;
		}catch(Exception e){
			return new HashMap<UUID, Address>();
		}
	}
	
	/**
	 * Get an address using it's addressId
	 */
	@Override
	public Address getObjByID(UUID objectId) {
		try {
			if(allAddresses.containsKey(objectId)){
				return allAddresses.get(objectId);
			}
			return null;
		}catch(Exception e){
			return null;
		}
	}

}
