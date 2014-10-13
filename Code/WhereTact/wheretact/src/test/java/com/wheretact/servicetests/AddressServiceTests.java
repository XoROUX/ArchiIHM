package com.wheretact.servicetests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.junit.Test;

import com.wheretact.models.Address;
import com.wheretact.service.AddressService;

public class AddressServiceTests {

	@Test
	public void testAddressService() {
		AddressService addressServiceOne = new AddressService();
		AddressService addressServiceTwo = new AddressService();
		
		assertEquals(false, addressServiceOne.equals(addressServiceTwo));
	}

	@Test
	public void testCreateObject() {
		AddressService addressServiceOne = new AddressService();
		UUID addressId = UUID.randomUUID();
		Address testAddress = new Address(addressId, 1000, "street", "test", "delete", "address", "country");
		
		assertEquals(0, addressServiceOne.createObject(testAddress));
		assertEquals(true, testAddress.equals(addressServiceOne.getObjByID(addressId)));
		
	}

	@Test
	public void testDeleteObject() {
		AddressService addressServiceOne = new AddressService();
		UUID addressId = UUID.randomUUID();
		Address testAddress = new Address(addressId, 1000, "street", "test", "delete", "address", "country");
		
		assertEquals(0, addressServiceOne.createObject(testAddress));
		assertEquals(true, testAddress.equals(addressServiceOne.getObjByID(addressId)));
		
		assertEquals(0, addressServiceOne.deleteObject(addressId));
		assertNull(addressServiceOne.getObjByID(addressId));
	}

	@Test
	public void testUpdateObject() {
		AddressService addressServiceOne = new AddressService();
		UUID addressId = UUID.randomUUID();
		Address testAddress = new Address(addressId, 1000, "street", "test", "delete", "address", "country");
		
		assertEquals(0, addressServiceOne.createObject(testAddress));
		assertEquals(true, testAddress.equals(addressServiceOne.getObjByID(addressId)));
		
		testAddress.setStreet("updated");
		testAddress.setCity("updated");
		testAddress.setCountry("updated");
		testAddress.setState("updated");
		testAddress.setPostcode("updated");
		
		assertEquals(0, addressServiceOne.updateObject(testAddress));
		
		Address updatedAddress = addressServiceOne.getObjByID(addressId);
		assertEquals(true, testAddress.equals(updatedAddress));
		
		assertEquals(true, testAddress.getStreet().equals(updatedAddress.getStreet()));
		assertEquals(true, testAddress.getCity().equals(updatedAddress.getCity()));
		assertEquals(true, testAddress.getCountry().equals(updatedAddress.getCountry()));
		assertEquals(true, testAddress.getState().equals(updatedAddress.getState()));
		assertEquals(true, testAddress.getPostcode().equals(updatedAddress.getPostcode()));
	}

	@Test
	public void testReadAll() {
		AddressService addressServiceOne = new AddressService();
		UUID addressId = UUID.randomUUID();
		Address testAddress = new Address(addressId, 1000, "street", "test", "delete", "address", "country");
		
		assertEquals(0, addressServiceOne.createObject(testAddress));
		
		ArrayList<Address> addressList = (ArrayList<Address>)addressServiceOne.readAll();
		
		assertEquals(addressServiceOne.getMapping().size(), addressServiceOne.readAll().size());
		assertNotNull(addressList);
		assertEquals(true, addressList.contains(testAddress));
	}

	@Test
	public void testGetMapping() {
		AddressService addressServiceOne = new AddressService();
		HashMap<UUID, Address> addressMap = addressServiceOne.getMapping();

		assertNotNull(addressMap);
		
		UUID addressId = UUID.randomUUID();
		Address testAddress = new Address(addressId, 1000, "street", "test", "delete", "address", "country");
		assertEquals(0, addressServiceOne.createObject(testAddress));
		
		assertNotNull(addressMap.get(addressId));
	}

	@Test
	public void testGetObjByID() {
		AddressService addressServiceOne = new AddressService();
		UUID addressId = UUID.randomUUID();
		Address testAddress = new Address(addressId, 1000, "street", "test", "delete", "address", "country");
		
		assertNull(addressServiceOne.getObjByID(addressId));
		
		assertEquals(0, addressServiceOne.createObject(testAddress));
		assertEquals(true, testAddress.equals(addressServiceOne.getObjByID(addressId)));
	}

}
