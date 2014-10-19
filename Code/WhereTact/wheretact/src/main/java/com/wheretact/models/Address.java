package com.wheretact.models;

import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/*
 * TO DO : 
 * 		-	Attributs Address OK
 * 		-	Constructeur -> génère un randomUUID()! (ok à verifier)
 * 		-	Getters  OK
 * 		-	Setters  OK
 * 		
 * 		-	Equals
 * 
 * v1 manu 08/10
 */

/**
 * Address class
 * Contains all the information of a given address.
 * 
 * @author Emmanuelle, Pierre
 *
 */
public class Address {

	private UUID contactId = null;
	private UUID addressId = null;
	private String  postcode, city, state, country, street;
	private int streetNumber;

	
	public UUID getContactId(){
		return contactId;	
	}
	
	public void setContactId(UUID contactId){
		this.contactId = contactId;
	}

	
	@NotNull
	public UUID getAddressId(){
			return addressId;	
	}
	

	@NotNull
	@Size(max=20)
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	@NotNull
	@Size(min=5, max=8)
	public String getPostcode() {
		return postcode;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	
	@NotNull
	@Size(max=20)
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	
	@NotNull
	@Size(max=20)
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	

	@NotNull
	@Size(max=50)
	public String getStreet(){
		return street;
	}
	
	public void setStreet(String street){
		this.street = street;
	}
	
	
	@NotNull
	public int getStreetNumber(){
		return streetNumber;
	}
	
	public void setStreetNumber(int streetNumber){
		this.streetNumber = streetNumber;
	}
	
	
	public Address(UUID contactId, UUID addressId, int streetNumber, String street, String postCode, String city, String state, String country) {
		this.contactId = contactId;
		this.addressId = addressId;
		this.streetNumber = streetNumber;
		this.street = street;
		this.addressId = addressId; 
		this.city = city;
		this.postcode = postCode;
		this.state = state;
		this.country = country; 
	}
	
	
	@Override
	public String toString(){
		
		return "Address [<ul><li>contactId=" + contactId + "</li><li> addressId=" + addressId + "</li><li> Number=" + streetNumber+ ", street=" + street
				+ "</li><li> postcode=" + postcode + ", city=" + city + "</li><li> country=" + country + ", state=" + state+ "</ul>]";
		
	}
	

	/**
	 * Equals method used to determine if two Addresses are the same
	 * @param otherAddress : object of same type to compare with
	 * @return : true if same object, same Id, or same city & postcode & state & country & street & streetNumber
	 */
	public boolean equals(Address otherAddress){
		if(this == otherAddress || addressId.equals(otherAddress.addressId)){
			return true;
		}
		else if(city.equals(otherAddress.city) && postcode.equals(otherAddress.postcode) 
				&& state.equals(otherAddress.state) && country.equals(otherAddress.country)
				&& street.equals(otherAddress.street) && streetNumber==otherAddress.streetNumber){
			return true;
		}
		return false;
	}
	
}
