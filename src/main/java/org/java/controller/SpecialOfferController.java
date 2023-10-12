package org.java.controller;

import org.java.db.pojo.Pizza;
import org.java.db.pojo.SpecialOffer;
import org.java.db.service.PizzaService;
import org.java.db.service.SpecialOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class SpecialOfferController {
	
	@Autowired
	private SpecialOfferService specialOfferService;
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/offer/create/{pizza_id}")
	public String create(
			@PathVariable ("pizza_id") int pizza_id,
			Model model) {
		
		model.addAttribute("specialOffer", new SpecialOffer());
		model.addAttribute("pizza", pizzaService.findById(pizza_id));
		
		return "specialOffer/create";
	}
	
	@PostMapping("/offer/create/{pizza_id}")
	public String store(
			@Valid @ModelAttribute SpecialOffer specialOffer,
			BindingResult bindingResult,
			@PathVariable ("pizza_id") int pizza_id,
			Model model
			) {
		
		if(bindingResult.hasErrors()) {
			return "specialOffer/create";
			}
		
		Pizza pizza = pizzaService.findById(pizza_id);
		specialOffer.setPizza(pizza);
		
		specialOfferService.save(specialOffer);
		
		System.out.println("New Special Offer saved on db");

		return "redirect:/pizza/{pizza_id}";
		
	}
	
}
