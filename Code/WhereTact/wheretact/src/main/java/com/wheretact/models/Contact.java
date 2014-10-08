package com.wheretact.models;

import java.util.HashMap;
import java.util.UUID;

public class Contact {

	private UUID contactId;
	private Address billingAddress;
	private HashMap<String, Address> addressList;
	
	
	
	/***
	 * TO DO : 
	 * 		-	Attributs Contact ok
	 * 		-	Constructeur -> génère un randomUUID()! a verifier
	 * 		-	Getters ok
	 * 		-	Setters ok
	 * 
	 * 		-	Equals gné??
	 */
	
	private Integer phoneNumbers;
	private String emails;
	private String firstname;
	private String lastname;
	private String birthdate; 
	
	
	public void setContactId(UUID contactId){
		this.contactId = contactId; 
	}
	
	public UUID getContactId(){
		return contactId; 
	}
	
	
	public Integer getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Integer phones) {
		this.phoneNumbers = phones;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress; 
		
	}
	
	
	public HashMap<String, Address> getAddressList() {
		return addressList;
	}
	
	public void setAddressList(String key,Address value) { // A VERIFIER
		addressList.put(key, value);
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String forname) {
		this.lastname = forname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	
	public static Contact builder(UUID contactId,String birthdate,String emails,String firstname, String lastname,Integer phoneNumbers) {
		
		Contact newContact = new Contact();
		
		newContact.setContactId(contactId.randomUUID()); 
		newContact.setBirthdate(birthdate);
		newContact.setEmails(emails);
		newContact.setFirstname(firstname);
		newContact.setLastname(lastname);
		newContact.setPhoneNumbers(phoneNumbers);
		
		
		return newContact;
	}

	
	
	
	
	
}
