package com.wheretact.business;

import com.wheretact.dao.*;

/**
 * WhereTact Data Access Object Provider/Manager (Factory) 
 * @author Pierre
 *
 */
public class WhereTactWebDAOFactory {

	//private static WhereTactWebDAOFactory instance = null;
/*
	private WhereTactWebDAOFactory() {

	}
	*/

	/**
	 * Singleton method 
	 * @return the current DAO Factory
	 */
	/*
	public static WhereTactWebDAOFactory getInstance() {
		if (instance == null) {
			instance = new WhereTactWebDAOFactory();
		} 
		return instance;
	}
	*/
	/**
	 * Provides access to address data
	 * @return the current address DAO
	 */
	public static AddressDAO getAddressDAO(){
		return AddressDAO.getInstance();
	}
	
	/**
	 * Provides access to contact data
	 * @return the current contact DAO
	 */
	public static ContactDAO getContactDAO(){
		return ContactDAO.getInstance();
	}
}
