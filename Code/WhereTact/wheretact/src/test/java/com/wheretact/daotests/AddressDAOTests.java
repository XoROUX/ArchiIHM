package com.wheretact.daotests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.junit.Test;

import com.wheretact.dao.AddressDAO;
import com.wheretact.models.Address;

public class AddressDAOTests {

	@Test
	public void testGetInstance() {
		AddressDAO addrDAO = AddressDAO.getInstance();
		
		assertNotNull(addrDAO);
		
		AddressDAO secondDAO = AddressDAO.getInstance();
		
		assertEquals(addrDAO, secondDAO);
	}

	/*
	@Test
	public void testStart() {
		AddressDAO addrDAO = AddressDAO.getInstance();
		
		
	}*/

	@Test
	public void testCreateObject() {
		AddressDAO addrDAO = AddressDAO.getInstance();
		int sizeOfHashMap = addrDAO.getMapping().size();
		
		UUID addressId = UUID.randomUUID();
		Address addressOne = new Address(null, addressId, 100, "street", "postCode", "city", "state", "country");
		
		addrDAO.createObject(addressOne);
		
		assertEquals(sizeOfHashMap+1, addrDAO.getMapping().size());
		
		assertEquals(true, addressOne.equals(addrDAO.getMapping().get(addressId)));
	}

	@Test
	public void testDeleteObject() {
		AddressDAO addrDAO = AddressDAO.getInstance();
		UUID addressId = UUID.randomUUID();
		Address addressOne = new Address(null, addressId, 1000, "street", "test", "delete", "address", "country");
		int sizeOfHashMap = addrDAO.getMapping().size();
		
		assertEquals(0, addrDAO.createObject(addressOne));
		assertEquals(sizeOfHashMap+1, addrDAO.getMapping().size());
		assertEquals(true, addressOne.equals(addrDAO.getMapping().get(addressId)));
		
		assertEquals(0, addrDAO.deleteObject(addressId));
		assertEquals(sizeOfHashMap, addrDAO.getMapping().size());
		assertEquals(null, addrDAO.getMapping().get(addressId));
	}

	@Test
	public void testUpdateObject() {
		AddressDAO addrDAO = AddressDAO.getInstance();
		UUID addressId = UUID.randomUUID();
		Address addressOne = new Address(null, addressId, 1000, "street", "test", "delete", "address", "country");
		
		assertEquals(0, addrDAO.createObject(addressOne));
		
		addressOne.setCity("UPDATED");
		addressOne.setStreet("UPDATED");
		addressOne.setCountry("UPDATED");
		addressOne.setState("UPDATED");
		addressOne.setPostcode("UPDATED");
		
		assertEquals(0, addrDAO.updateObject(addressOne));
		
		Address getAddress = addrDAO.getMapping().get(addressId);
		assertEquals("UPDATED", getAddress.getCity());
		assertEquals("UPDATED", getAddress.getStreet());
		assertEquals("UPDATED", getAddress.getCountry());
		assertEquals("UPDATED", getAddress.getPostcode());
		assertEquals("UPDATED", getAddress.getState());
	}

	@Test
	public void testReadAll() {
		AddressDAO addrDAO = AddressDAO.getInstance();
		
		UUID addressId = UUID.randomUUID();
		Address addressOne = new Address(null, addressId, 1000, "street", "test", "delete", "address", "country");
		assertEquals(0, addrDAO.createObject(addressOne));
		
		ArrayList<Address> addressList = (ArrayList<Address>)addrDAO.readAll();
		
		assertEquals(addrDAO.getMapping().size(), addrDAO.readAll().size());
		assertNotNull(addressList);
		assertEquals(true, addressList.contains(addressOne));
	}

	@Test
	public void testGetMapping() {
		AddressDAO addrDAO = AddressDAO.getInstance();
		HashMap<UUID, Address> addressMap = addrDAO.getMapping();

		assertNotNull(addressMap);
		
		UUID addressId = UUID.randomUUID();
		Address addressOne = new Address(null, addressId, 1000, "street", "test", "delete", "address", "country");
		assertEquals(0, addrDAO.createObject(addressOne));
		
		assertNotNull(addressMap.get(addressId));
	}

	@Test
	public void testGetObjByID() {
		AddressDAO addrDAO = AddressDAO.getInstance();
		UUID addressId = UUID.randomUUID();
		Address addressOne = new Address(null, addressId, 1000, "street", "test", "delete", "address", "country");
		
		assertEquals(0, addrDAO.createObject(addressOne));
		
		assertEquals(true, addressOne.equals(addrDAO.getObjByID(addressId)));
	}

}
