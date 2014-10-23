package com.wheretact.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wheretact.models.Contact;
import com.wheretact.service.ContactService;

@Controller
public class ContactController {
	
	@RequestMapping(value="/contacts")
	public String contacts(Locale locale, Model model){
		ContactService sampleContacts = new ContactService();
		ArrayList<Contact> contactList = (ArrayList<Contact>) sampleContacts.readAll();
		model.addAttribute("contactList", contactList);
		return "contacts";
	}
	
	/*
	@RequestMapping(value="/contacts/{id}")
	public String contact(){
		
		return "contact";
	}*/

	@RequestMapping(value="/contacts/formCreateContact")
	public String formCreateContact(){
		
		return "formCreateContact";
	}
}
