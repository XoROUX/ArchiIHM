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

	private UUID contactId = null;
	private Address billingAddress = null;
	private HashMap<UUID, Address> addressList = null;	
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
	public Contact(UUID contactId,String birthdate,String email,String firstname, String lastname,int phoneNumber, HashMap<UUID, Address> addresses, Address billingAddr) {
		
		this.contactId = contactId; 
		this.birthdate = birthdate;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		if(addresses == null){
			this.addressList = new HashMap<UUID, Address>();
		}
		else{
			this.addressList = addresses;
		}
		this.billingAddress = billingAddr;
	}
	
	
	/* GETTERS & SETTERS */
	
	public HashMap<UUID, Address> getAddressList() {
		return addressList;
	}
	
	public void setAddressList(HashMap<UUID, Address> myAddressList) { // A VERIFIER
		addressList = myAddressList;
	}
	
	public void addContactAddress(UUID key, Address value){
		addressList.put(key, value);
	}
	
	public void removeContactAddress(UUID key){
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
		
	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phone) {
		this.phoneNumber = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "<br><p>______________________________Contact___________________________________</p>"
				+ "[<ul><li>contactId=" + contactId + "</li><li> phoneNumber=" + phoneNumber + "</li><li> email=" + email
				+ "</li><li> firstname=" + firstname + ", lastname=" + lastname
				+ "</li><li> birthdate=" + birthdate + "</ul>]";
	}	
	
}
