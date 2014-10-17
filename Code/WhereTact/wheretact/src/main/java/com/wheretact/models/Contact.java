package com.wheretact.models;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


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
	private Date birthdate; 
	
	/**
	 * Constructor for Contact Class
	 * @param contactId
	 * @param birthdate
	 * @param email
	 * @param firstname
	 * @param lastname
	 * @param phoneNumber
	 */
	public Contact(UUID contactId,Date birthdate,String email,String firstname, String lastname,int phoneNumber, HashMap<UUID, Address> addresses, Address billingAddr) {
		
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
	@NotNull
	@Digits(integer=1,fraction=0)
		public UUID getContactId(){
		return contactId; 
	}
		

	@NotNull
	@Digits(integer=5,fraction=0)
	public int getPhoneNumber() {

		return phoneNumber;
	}
	


	public void setPhoneNumber(int phone) {
		this.phoneNumber = phone;
	}

	
	@NotNull
	@Size(max=50)
	public String getEmail() {
		return email;
	}
	


	public void setEmail(String email) {
		this.email = email;
	}
	@NotNull
	public Address getBillingAddress() {
		return billingAddress;
	}

	
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress; 
		
	}
	
	@NotNull
	@Size(max=20)
	public String getFirstname() {
		return firstname;
	}
	

	
	
	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	@NotNull
	@Size(max=20)
	public String getLastname() {
		return lastname;
	}


	
	public void setLastname(String forname) {
		this.lastname = forname;
	}


	@NotNull
	@Past	
	public Date getBirthdate() {
		return birthdate;
	}

	
	public void setBirthdate(Date birthdate) {
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
