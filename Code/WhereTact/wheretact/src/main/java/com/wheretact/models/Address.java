package com.wheretact.models;


import java.util.UUID;

public class Address {

	private UUID addressId;
	private Boolean isBillingAddress = false;
	private String  postcode, city, state,country;
	
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
	
	public UUID getAddressId(){
			return addressId;	
	}
	
	public void setAddressId(UUID addressID){
		this.addressId = addressId; 
	}
	
	
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
	
	public static Address builder(UUID addressId, String street, String postCode, String city, String state, String country) {
		
		
		
		Address newAddress = new Address();
		newAddress.setAddressId(addressId.randomUUID()); 
		newAddress.setCity(city);
		newAddress.setPostcode(postCode);
		newAddress.setState(state);
		newAddress.setCountry(country);
		
		return newAddress;
	}
	
}
