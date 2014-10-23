package com.wheretact.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wheretact.service.AddressService;
import com.wheretact.service.ContactService;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public String home(Locale locale, Model model){
		
		/*
		 * Affichage de la date dans la page, calcul de la l'heure actuelle (française)
		 */
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );

		ContactService sampleContacts = new ContactService();
		AddressService sampleAddresses = new AddressService();
		
		int totalContacts = sampleContacts.getMapping().size();
		int totalAddresses = sampleAddresses.getMapping().size();
		
		model.addAttribute("totalContacts", totalContacts );
		model.addAttribute("totalAddresses", totalAddresses);
		
		/*
		 * GO TO home.jsp
		 */
		return "home";
	}
}
