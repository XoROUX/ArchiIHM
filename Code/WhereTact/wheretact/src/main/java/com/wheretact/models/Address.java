package com.wheretact.models;


import java.util.UUID;

/***
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


public class Address {

	private UUID addressId;
	private String  postcode, city, state, country, street;
	private int streetNumber;


	public UUID getAddressId(){
			return addressId;	
	}
	
	/* On ne permet pas de modifier l'id
	public void setAddressId(UUID addressID){
		this.addressId = addressId; 
	}*/
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getStreet(){
		return street;
	}
	
	public void setStreet(String street){
		this.street = street;
	}
	
	public int getStreetNumber(){
		return streetNumber;
	}
	
	public void setStreetNumber(int streetNumber){
		this.streetNumber = streetNumber;
	}
	
	public Address(UUID addressId, int streetNumber, String street, String postCode, String city, String state, String country) {
		
		this.addressId = addressId;
		this.streetNumber = streetNumber;
		this.street = street;
		this.addressId = addressId; 
		this.city = city;
		this.postcode = postCode;
		this.state = state;
		this.country = country; 
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
