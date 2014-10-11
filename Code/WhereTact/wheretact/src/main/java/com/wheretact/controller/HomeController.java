package com.wheretact.controller;

import java.text.DateFormat;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wheretact.models.*;
import com.wheretact.service.ContactService;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public String home(Locale locale, Model model){
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		Contact sampleContact = new Contact(UUID.randomUUID(), "date", "random@user.com", "Random", "User", 1337, null, null);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("randomUserInfo", sampleContact.toString());
		
		ContactService sampleContacts = new ContactService();
		
		/*
		Collection<Contact> contactList = (Collection<Contact>) sampleContacts.getMapping().values();
		
		String myList = new String();
		myList = "<p>";
		
		if(sampleContacts.getMapping().values().size() == 0){
			myList += "No elements recieved from service <br>";
		}
		else {
			try {
				for(Contact contact : contactList){
					myList += contact.toString() + "<br>";
									
				}
	
			}catch(Exception e){
				myList = "There was an error in the list";
			}
		}
		*/
		
		ArrayList<Contact> contactList = (ArrayList<Contact>) sampleContacts.readAll();
		
		String myList = new String();
		myList = "<p>";
		
		if(sampleContacts.getMapping().values().size() == 0){
			myList += "No elements recieved from service <br>";
		}
		else {
			try {
				for(Contact contact : contactList){
					myList += contact.toString() + "<br>";
									
				}
	
			}catch(Exception e){
				myList = "There was an error in the list";
			}
		}
		
			
		myList += "</p>";
		
		model.addAttribute("myList", myList);
		/*
		 * GO TO home.jsp
		 */
		return "home";
	}
}
