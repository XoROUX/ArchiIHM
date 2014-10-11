package com.wheretact.modeltests;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import com.wheretact.models.Address;


public class AddressTests {

	@Test
	public void testAddress() {
		Address address = new Address(UUID.randomUUID(), 100, "street", "postCode", "city", "state", "country");
		
		/*
		 * Testing Getters and Setters
		 */
		assertEquals((double)100, (double)address.getStreetNumber(), 0);
		assertEquals("street", address.getStreet());
		assertEquals("country", address.getCountry());
	}

	@Test
	public void testEqualsAddress() {
		UUID sameUUID = UUID.randomUUID();
		Address addressOne = new Address(sameUUID, 100, "street", "postCode", "city", "state", "country");
		Address addressOneModified = new Address(sameUUID, 200, "NOT", "THE", "SAME", "_", "INFO");
		
		/*
		 * Checks that two entities with the same ID are considered equal
		 */
		assertEquals(true, addressOne.equals(addressOneModified));
		
		UUID newUUID = UUID.randomUUID();
		Address addressTwo  = new Address(newUUID, 100, "street", "postCode", "city", "state", "country");
		
		/*
		 * Checks that two addresses with same information (excluding ID) are considered equal
		 */
		assertEquals(true, addressOne.equals(addressTwo));
	}

}
