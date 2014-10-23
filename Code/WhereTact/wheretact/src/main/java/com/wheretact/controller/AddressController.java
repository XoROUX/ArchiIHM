package com.wheretact.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wheretact.models.Address;
import com.wheretact.service.AddressService;

@Controller
public class AddressController {
	
	@RequestMapping(value="/addresses")
	public String users(Locale locale, Model model){
		AddressService sampleAddresses = new AddressService();
		ArrayList<Address> addressList = (ArrayList<Address>) sampleAddresses.readAll();
		model.addAttribute("addressList", addressList);
		return "addresses";
	}
	
	@RequestMapping(value="/addresses/{id}")
	public String user(){
		
		return "adresse";
	}

	@RequestMapping(value="/addresses/new")
	public String createUser(){
		
		return "createAdresse";
	}
}
