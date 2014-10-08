package com.wheretact.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wheretact.models.*;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public String home(Locale locale, Model model){
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		Contact sampleContact = new Contact(UUID.randomUUID(), "date", "random@user.com", "Random", "User", 1337);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("randomUserInfo", sampleContact.toString());
		return "home";
	}
}
