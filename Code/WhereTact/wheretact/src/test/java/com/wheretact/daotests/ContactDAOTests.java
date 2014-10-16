package com.wheretact.daotests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.junit.Test;

import com.wheretact.dao.ContactDAO;
import com.wheretact.models.Contact;

public class ContactDAOTests {

	@Test
	public void testGetInstance() {
		ContactDAO contactDAO = ContactDAO.getInstance();
		
		assertNotNull(contactDAO);
		
		ContactDAO secondDAO = ContactDAO.getInstance();
		
		assertEquals(contactDAO, secondDAO);
	}

	/*
	@Test
	public void testStart() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testCreateObject() {
		ContactDAO contactDAO = ContactDAO.getInstance();
		int sizeOfHashMap = contactDAO.getMapping().size();
		
		UUID contactId = UUID.randomUUID();
		Contact contactOne = new Contact(contactId, "birthdate", "email", "firstname", "lastname", 1007, null, null);
		
		contactDAO.createObject(contactOne);
		
		assertEquals(sizeOfHashMap+1, contactDAO.getMapping().size());
		
		assertEquals(true, contactOne.equals(contactDAO.getMapping().get(contactId)));
	}

	@Test
	public void testDeleteObject() {
		ContactDAO contactDAO = ContactDAO.getInstance();
		UUID contactId = UUID.randomUUID();
		Contact contactOne = new Contact(contactId, "birthdate", "email", "firstname", "lastname", 1008, null, null);
		int sizeOfHashMap = contactDAO.getMapping().size();
		
		assertEquals(0, contactDAO.createObject(contactOne));
		assertEquals(sizeOfHashMap+1, contactDAO.getMapping().size());
		assertEquals(true, contactOne.equals(contactDAO.getMapping().get(contactId)));
		
		assertEquals(0, contactDAO.deleteObject(contactId));
		assertEquals(sizeOfHashMap, contactDAO.getMapping().size());
		assertEquals(null, contactDAO.getMapping().get(contactId));
	}

	@Test
	public void testUpdateObject() {
		ContactDAO contactDAO = ContactDAO.getInstance();
		UUID contactId = UUID.randomUUID();
		Contact contactOne = new Contact(contactId, "birthdate", "email", "firstname", "lastname", 1009, null, null);
		
		assertEquals(0, contactDAO.createObject(contactOne));
		
		contactOne.setBirthdate("UPDATED");
		contactOne.setEmails("UPDATED");
		contactOne.setFirstname("UPDATED");
		contactOne.setLastname("UPDATED");
		
		assertEquals(0, contactDAO.updateObject(contactOne));
		
		Contact getContact = contactDAO.getMapping().get(contactId);
		assertEquals("UPDATED", getContact.getBirthdate());
		assertEquals("UPDATED", getContact.getFirstname());
		assertEquals("UPDATED", getContact.getLastname());
		assertEquals("UPDATED", getContact.getEmails());
	}

	@Test
	public void testReadAll() {
		ContactDAO contactDAO = ContactDAO.getInstance();
		
		UUID contactId = UUID.randomUUID();
		Contact contactOne = new Contact(contactId, "birthdate", "email", "firstname", "lastname", 1010, null, null);
		assertEquals(0, contactDAO.createObject(contactOne));
		
		ArrayList<Contact> addressList = (ArrayList<Contact>)contactDAO.readAll();
		
		assertEquals(contactDAO.getMapping().size(), contactDAO.readAll().size());
		assertNotNull(addressList);
		assertEquals(true, addressList.contains(contactOne));
	}

	@Test
	public void testGetMapping() {
		ContactDAO contactDAO = ContactDAO.getInstance();
		HashMap<UUID, Contact> addressMap = contactDAO.getMapping();

		assertNotNull(addressMap);
		
		UUID contactId = UUID.randomUUID();
		Contact contactOne = new Contact(contactId, "birthdate", "email", "firstname", "lastname", 1011, null, null);
		assertEquals(0, contactDAO.createObject(contactOne));
		
		assertNotNull(addressMap.get(contactId));
	}

	@Test
	public void testGetObjByID() {
		ContactDAO contactDAO = ContactDAO.getInstance();
		UUID contactId = UUID.randomUUID();
		Contact contactOne = new Contact(contactId, "birthdate", "email", "firstname", "lastname", 1011, null, null);
		
		assertEquals(0, contactDAO.createObject(contactOne));
		
		assertEquals(true, contactOne.equals(contactDAO.getObjByID(contactId)));
	}

}