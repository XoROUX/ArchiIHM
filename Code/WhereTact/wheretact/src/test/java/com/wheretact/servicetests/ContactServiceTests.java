package com.wheretact.servicetests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.junit.Test;

import com.google.appengine.repackaged.org.joda.time.DateTime;
import com.wheretact.models.Contact;
import com.wheretact.service.ContactService;

public class ContactServiceTests {

	@Test
	public void testContactService() {
		ContactService contactServiceOne = new ContactService();
		ContactService contactServiceTwo = new ContactService();
		
		assertEquals(false, contactServiceOne.equals(contactServiceTwo));
	}

	@Test
	public void testCreateObject() {
		ContactService contactServiceOne = new ContactService();
		UUID contactId = UUID.randomUUID();
		Contact testContact = new Contact(contactId, new DateTime().toDate(), "email", "firstname", "lastname", 13377331, null, null);
		
		assertEquals(0, contactServiceOne.createObject(testContact));
		assertEquals(true, testContact.equals(contactServiceOne.getObjByID(contactId)));
	}

	@Test
	public void testDeleteObject() {
		ContactService contactServiceOne = new ContactService();
		UUID contactId = UUID.randomUUID();
		Contact testContact = new Contact(contactId, new DateTime().toDate(), "email", "firstname", "lastname", 13377331, null, null);
		
		assertEquals(0, contactServiceOne.createObject(testContact));
		assertEquals(true, testContact.equals(contactServiceOne.getObjByID(contactId)));
		
		assertEquals(0, contactServiceOne.deleteObject(contactId));
		assertNull(contactServiceOne.getObjByID(contactId));
	}

	@Test
	public void testUpdateObject() {
		ContactService contactServiceOne = new ContactService();
		UUID contactId = UUID.randomUUID();
		Contact testContact = new Contact(contactId, new DateTime().toDate(), "email", "firstname", "lastname", 13377331, null, null);
		
		assertEquals(0, contactServiceOne.createObject(testContact));
		assertEquals(true, testContact.equals(contactServiceOne.getObjByID(contactId)));
		
		testContact.setBirthdate(new DateTime().toDate());
		testContact.setEmail("updated");
		testContact.setFirstname("updated");
		testContact.setLastname("updated");
		
		assertEquals(0, contactServiceOne.updateObject(testContact));
		
		Contact updatedContact = contactServiceOne.getObjByID(contactId);
		assertEquals(true, testContact.equals(updatedContact));
		
		assertEquals(true, testContact.getBirthdate().equals(updatedContact.getBirthdate()));
		assertEquals(true, testContact.getEmail().equals(updatedContact.getEmail()));
		assertEquals(true, testContact.getFirstname().equals(updatedContact.getFirstname()));
		assertEquals(true, testContact.getLastname().equals(updatedContact.getLastname()));
	}

	@Test
	public void testReadAll() {
		ContactService contactServiceOne = new ContactService();
		
		UUID contactId = UUID.randomUUID();
		Contact contactOne = new Contact(contactId, new DateTime().toDate(), "email", "firstname", "lastname", 1010, null, null);
		assertEquals(0, contactServiceOne.createObject(contactOne));
		
		ArrayList<Contact> addressList = (ArrayList<Contact>)contactServiceOne.readAll();
		
		assertEquals(contactServiceOne.getMapping().size(), contactServiceOne.readAll().size());
		assertNotNull(addressList);
		assertEquals(true, addressList.contains(contactOne));
	}

	@Test
	public void testGetMapping() {
		ContactService contactServiceOne = new ContactService();
		HashMap<UUID, Contact> addressMap = contactServiceOne.getMapping();

		assertNotNull(addressMap);
		
		UUID contactId = UUID.randomUUID();
		Contact contactOne = new Contact(contactId, new DateTime().toDate(), "email", "firstname", "lastname", 1011, null, null);
		assertEquals(0, contactServiceOne.createObject(contactOne));
		
		assertNotNull(addressMap.get(contactId));
	}

	@Test
	public void testGetObjByID() {
		ContactService contactServiceOne = new ContactService();
		UUID contactId = UUID.randomUUID();
		Contact testContact = new Contact(contactId, new DateTime().toDate(), "email", "firstname", "lastname", 13377331, null, null);
		
		assertNull(contactServiceOne.getObjByID(contactId));
		
		assertEquals(0, contactServiceOne.createObject(testContact));
		assertEquals(true, testContact.equals(contactServiceOne.getObjByID(contactId)));
	}

}
