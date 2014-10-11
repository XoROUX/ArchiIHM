package com.wheretact.models;

import java.util.HashMap;
import java.util.UUID;


/*
 * TO DO : 
 * 		-	Attributs Contact ok
 * 		-	Constructeur -> génère un randomUUID()! a verifier
 * 		-	Getters ok
 * 		-	Setters ok
 * 
 * 		-	Equals gné??
 */

/**
 * Contact class
 * Contains all the information of a given contact.
 * 
 * @author Emmanuelle, Pierre
 *
 */
public class Contact {

	private UUID contactId;
	private Address billingAddress;
	private HashMap<String, Address> addressList;	
	private int phoneNumber;
	private String email;
	private String firstname;
	private String lastname;
	private String birthdate; 
	
	/**
	 * Constructor for Contact Class
	 * @param contactId
	 * @param birthdate
	 * @param email
	 * @param firstname
	 * @param lastname
	 * @param phoneNumber
	 */
	public Contact(UUID contactId,String birthdate,String email,String firstname, String lastname,Integer phoneNumber, HashMap<String, Address> addresses, Address billingAddr) {
		
		this.contactId = contactId; 
		this.birthdate = birthdate;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		if(addresses == null){
			this.addressList = new HashMap<String, Address>();
		}
		else{
			this.addressList = addresses;
		}
		this.billingAddress = billingAddr;
	}
	
	
	/* GETTERS & SETTERS */
	
	public HashMap<String, Address> getAddressList() {
		return addressList;
	}
	
	public void setAddressList(HashMap<String, Address> myAddressList) { // A VERIFIER
		addressList = myAddressList;
	}
	
	public void addContactAddress(String key, Address value){
		addressList.put(key, value);
	}
	
	public void removeContactAddress(String key){
		if(addressList.containsKey(key)){
			addressList.remove(key);
		}
	}
	/* On ne permet pas de modifier l'id
	public void setContactId(UUID contactId){
		this.contactId = contactId; 
	}*/
	
	public UUID getContactId(){
		return contactId; 
	}
		
	public Integer getPhoneNumbers() {
		return phoneNumber;
	}

	public void setPhoneNumbers(Integer phones) {
		this.phoneNumber = phones;
	}

	public String getEmails() {
		return email;
	}

	public void setEmails(String emails) {
		this.email = emails;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress; 
		
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

	
	/**
	 * Equals method used to determine if two Contacts are the same
	 * @param otherContact : object of same type to compare with
	 * @return : true if same object, same Id, or same email address
	 */
	public boolean equals(Contact otherContact){
		if(this == otherContact || contactId.equals(otherContact.contactId)){
			return true;
		}
		else if(email.equals(otherContact.email)){
			return true;
		}
		return false;
	}


	@Override
	public String toString() {
		return "Contact [\n\tcontactId=" + contactId + "\n\t phoneNumber=" + phoneNumber + "\n\t email=" + email
				+ "\n\t firstname=" + firstname + ", lastname=" + lastname
				+ "\n\t birthdate=" + birthdate + "\n]";
	}	
	
}
