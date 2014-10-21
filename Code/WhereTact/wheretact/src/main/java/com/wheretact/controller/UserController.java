package com.wheretact.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wheretact.models.Contact;
import com.wheretact.service.ContactService;

@Controller
public class UserController {
	
	@RequestMapping(value="/users")
	public String users(Locale locale, Model model){
		ContactService sampleContacts = new ContactService();
		ArrayList<Contact> contactList = (ArrayList<Contact>) sampleContacts.readAll();
		model.addAttribute("contactList", contactList);
		return "users";
	}
	
	@RequestMapping(value="/user/{id}")
	public String user(){
		
		return "user";
	}

	@RequestMapping(value="/user/new")
	public String createUser(){
		
		return "createUser";
	}
}
