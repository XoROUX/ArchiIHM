package com.wheretact.modeltests;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import com.google.appengine.repackaged.org.joda.time.DateTime;
import com.wheretact.models.Contact;

public class ContactTests {

	@Test
	public void testContact() {
		Contact contact = new Contact(UUID.randomUUID(), new DateTime().toDate(), "email", "firstname", "lastname", 911, null, null);
		
		/*
		 * Testing Getters and Setters
		 */
		assertEquals((double)911, (double)contact.getPhoneNumber(), 0);
		assertEquals("lastname", contact.getLastname());
		assertEquals("email", contact.getEmail());
	}
	
	@Test
	public void testEquals(){
		
		UUID sameUUID = UUID.randomUUID();
		Contact contactOne = new Contact(sameUUID, new DateTime().toDate(), "email", "firstname", "lastname", 911, null, null);
		Contact contactOneModified = new Contact(sameUUID, new DateTime().toDate(), "THE", "SAME", "INFO", 911, null, null);
		
		/*
		 * Checks that two entities with the same ID are considered equal
		 */
		assertEquals(true, contactOne.equals(contactOneModified));
		
		UUID newUUID = UUID.randomUUID();
		Contact contactTwo  = new Contact(newUUID, new DateTime().toDate(), "email", "firstname", "lastname", 911, null, null);
		
		/*
		 * Checks that two contacts with same information (excluding ID) are considered equal
		 */
		assertEquals(true, contactOne.equals(contactTwo));
	}

}
