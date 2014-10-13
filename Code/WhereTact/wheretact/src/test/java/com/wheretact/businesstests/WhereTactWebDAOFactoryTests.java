package com.wheretact.businesstests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.wheretact.business.WhereTactWebDAOFactory;
import com.wheretact.dao.AddressDAO;
import com.wheretact.dao.ContactDAO;

public class WhereTactWebDAOFactoryTests {

	@Test
	public void testGetAddressDAO() {
		AddressDAO myTestDAO = WhereTactWebDAOFactory.getAddressDAO();
		AddressDAO myTestDAOTwo = WhereTactWebDAOFactory.getAddressDAO();
		
		assertNotNull(myTestDAO);
		assertNotNull(myTestDAOTwo);
		
		assertEquals(true, myTestDAO.equals(myTestDAOTwo));
	}

	@Test
	public void testGetContactDAO() {
		ContactDAO myTestDAO = WhereTactWebDAOFactory.getContactDAO();
		ContactDAO myTestDAOTwo = WhereTactWebDAOFactory.getContactDAO();
		
		assertNotNull(myTestDAO);
		assertNotNull(myTestDAOTwo);
		
		assertEquals(true, myTestDAO.equals(myTestDAOTwo));
	}

}
