package com.wheretact.controller;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface WhereTactServiceInterface<T> {

	/**
	 * Creates an object by inserting it into the HashMap
	 * It does not add an object if the object already existed.
	 * @param myObject : the object to add to the map
	 * @return 0 if added correctly, 1 if it already existed, 2 on exception
	 */
	public int createObject(T myObject);
	
	/**
	 * Deletes an object from the HashMap
	 * @param objectId : Id of the object to remove
	 * @return : 0 if removed, 1 if not found in map, 2 if an exception occurs
	 */
	public int deleteObject(UUID objectId);
	
	/**
	 * Updates an object in the HashMap
	 * @param objectId : Id of the object to update
	 * @return : 0 if updated, 1 if not found in map, 2 if an exception occurs
	 */
	public int updateObject(T myNewObj);
	
	/**
	 * Read as a list 
	 * @return a list of the objects in the HashMap
	 */
	public List<T> readAll();
	
	/**
	 * Read as HashMap
	 * @return the DAO's HashMap
	 */
	public HashMap<UUID, T> getMapping();
	
	/**
	 * Finds an object in the map
	 * @param objectId : Id of the object to retrieve
	 * @return : The object if found, null otherwise
	 */
	public T getObjByID(UUID objectId);
}