package com.wheretact.controller;

import java.text.DateFormat;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Date;
import java.util.Locale;
//import java.util.UUID;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wheretact.models.*;
import com.wheretact.service.AddressService;
import com.wheretact.service.AngularDataProvider;
import com.wheretact.service.ContactService;

@Controller
public class HomeController {

	@RequestMapping(value="/home")
	public String home(Locale locale, Model model){
		
		/*
		 * Affichage de la date dans la page, calcul de la l'heure actuelle (française)
		 */
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);

//		Contact sampleContact = new Contact(UUID.randomUUID(), "date", "random@user.com", "Random", "User", 1337, null, null);
		
		model.addAttribute("serverTime", formattedDate );
//		model.addAttribute("randomUserInfo", sampleContact.toString());
		
		ContactService sampleContacts = new ContactService();
		AddressService sampleAddresses = new AddressService();
		String myList = "";
		
		int totalContacts = sampleContacts.getMapping().size();
		int totalAddresses = sampleAddresses.getMapping().size();
		
		model.addAttribute("totalContacts", totalContacts );
		model.addAttribute("totalAddresses", totalAddresses);
		
		/*
		 * Liste des Addresses dans la mémoire (format test/debug)
		if(sampleAddresses != null && sampleAddresses.readAll() != null){
			myList += "<p>__________ADDRESSES_________ </p>";
			for(Address a : sampleAddresses.readAll()){
				myList += "<br><p> " + a.toString() + " </p>";
			}
			if(sampleAddresses.readAll().size() == 0){
				myList += "<br><p> No addresses found in Address Mapping. </p>";
			}
		}*/
		model.addAttribute("angularTestContacts", AngularDataProvider.convertContacts(sampleContacts.getMapping()));
		model.addAttribute("angularTestAddresses", AngularDataProvider.convertAddresses(sampleAddresses.getMapping()));
		
		ArrayList<Contact> contactList = (ArrayList<Contact>) sampleContacts.readAll();
		
		if(sampleContacts.getMapping().values().size() == 0){
			myList += "<p>No elements recieved from service </p>";
		}
		else {
			try {
				for(Contact contact : contactList){
					myList += "<p>" + contact.toString() + "</p>";
					myList += "<br><ul>";
					
					if(contact.getAddressList() != null && contact.getAddressList().size() > 0){
						
						for(Address a : contact.getAddressList().values()){
							myList += "<li>" + a.toString() + "</li>";
						}
					}
						
					else if(contact.getBillingAddress() != null){	
						myList += "<li>" + contact.getBillingAddress().toString() + "</li>";
					}
					
					else {
						myList += "<li>Addresses : None found here.</li>";
					}
					myList += "</ul><br>";
					
									
				}
	
			}catch(Exception e){
				myList = "<li>" + "There was an error in the list" + "</li>";
			}
		}
		
			
		myList += "</ul>";
		
		model.addAttribute("myList", myList);
		/*
		 * GO TO home.jsp
		 */
		return "home";
	}
}
