package com.wheretact.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wheretact.models.Address;
import com.wheretact.service.AddressService;

@Controller
public class AdresseController {
	
	@RequestMapping(value="/adresses")
	public String users(Locale locale, Model model){
		AddressService sampleAddresses = new AddressService();
		ArrayList<Address> adresseList = (ArrayList<Address>) sampleAddresses.readAll();
		model.addAttribute("adresseList", adresseList);
		return "adresses";
	}
	
	@RequestMapping(value="/adresse/{id}")
	public String user(){
		
		return "adresse";
	}

	@RequestMapping(value="/adresse/new")
	public String createUser(){
		
		return "createAdresse";
	}
}
