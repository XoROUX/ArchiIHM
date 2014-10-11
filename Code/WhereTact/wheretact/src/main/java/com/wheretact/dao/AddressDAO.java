package com.wheretact.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.wheretact.business.WhereTactWebDAOInterface;
import com.wheretact.models.Address;


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
 * @author Pierre
 *
 */
public class AddressDAO implements WhereTactWebDAOInterface<Address> {

	private static AddressDAO instance = null;
	private HashMap<UUID, Address> allAddresses;
	
	/**
	 * @Constructor
	 */
	private AddressDAO() {
		this.allAddresses = new HashMap<UUID, Address>();
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
		// TODO Write File Reader and set allAddresses HashMap
		
	}
	
	/**
	 * Create an address
	 */
	@Override
	public int createObject(Address myObject) {
		try{
			if(allAddresses.containsKey(myObject.getAddressId())){
				return 1; 
			}
			allAddresses.put(myObject.getAddressId(), myObject);
			return 0;
			
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
