package com.wheretact.service;

import java.util.HashMap;
import java.util.UUID;

import com.wheretact.models.Address;
import com.wheretact.models.Contact;

public class AngularDataProvider {

	public static String convertContacts(HashMap<UUID, Contact> map){
		String json = "[";
		for(Contact c : map.values()){
			json += "{contactId: '" + c.getContactId().toString() + "'"
					+"birthdate: '"+ c.getBirthdate() + "'"
					+"email: '"+ c.getEmail() + "'"
					+"firstname: '"+ c.getFirstname() + "'"
					+"lastname: '"+ c.getLastname() + "'"
					+"phoneNumber: '"+ c.getPhoneNumber() + "'";

//			if(c.getAddressList() == null || c.getAddressList().size()==0){
//				
//			}
			
			json += "}";
		}
		return json+"]";
	}
	
	public static String convertAddresses(HashMap<UUID, Address> map){
		String json = "[";
		for(Address a : map.values()){
			json += "{'contactId': '" + a.getContactId().toString() + "'"
					+"'addressId': '" + a.getAddressId().toString() + "'"
					+"'email': '"+ a.getStreetNumber() + "'"
					+"'firstname': '"+ a.getStreet() + "'"
					+"'lastname': '"+ a.getPostcode() + "'"
					+"'lastname': '"+ a.getCity() + "'"
					+"'lastname': '"+ a.getCountry() + "'"
					+"'lastname': '"+ a.getState() + "'";
			
			json += "}";
		}
		return json+"]";
	}
}
