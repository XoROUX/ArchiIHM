package com.wheretact.modeltests;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import com.wheretact.models.Contact;

public class ContactTests {

	@Test
	public void testContact() {
		Contact contact = new Contact(UUID.randomUUID(), "birthdate", "email", "firstname", "lastname", 911, null, null);
		
		/*
		 * Testing Getters and Setters
		 */
		assertEquals((double)911, (double)contact.getPhoneNumber(), 0);
		assertEquals("birthdate", contact.getBirthdate());
		assertEquals("email", contact.getEmail());
	}
	
	@Test
	public void testEquals(){
		
		UUID sameUUID = UUID.randomUUID();
		Contact contactOne = new Contact(sameUUID, "birthdate", "email", "firstname", "lastname", 911, null, null);
		Contact contactOneModified = new Contact(sameUUID, "NOT", "THE", "SAME", "INFO", 911, null, null);
		
		/*
		 * Checks that two entities with the same ID are considered equal
		 */
		assertEquals(true, contactOne.equals(contactOneModified));
		
		UUID newUUID = UUID.randomUUID();
		Contact contactTwo  = new Contact(newUUID, "birthdate", "email", "firstname", "lastname", 911, null, null);
		
		/*
		 * Checks that two contacts with same information (excluding ID) are considered equal
		 */
		assertEquals(true, contactOne.equals(contactTwo));
	}

}
