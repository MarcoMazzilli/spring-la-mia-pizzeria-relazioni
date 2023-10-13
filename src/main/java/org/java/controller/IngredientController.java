package org.java.controller;

import org.java.db.pojo.Ingredient;
import org.java.db.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class IngredientController {
	
	@Autowired
	private IngredientService ingredientService;
	
	
	// INDEX
	@GetMapping("ingredient/index")
	public String getIndex(Model model) {
		
		model.addAttribute("ingredients", ingredientService.findAll());
		
		return "ingredient/index";
	}
	
	// CREATE
	@GetMapping("ingredient/create")
	public String create(
			Model model) {
			
		model.addAttribute("newIngredient", new Ingredient());
		
		return "ingredient/create";
	}
	
	// STORE 
	@PostMapping("ingredient/create")
	public String store(
			Model model,
			@Valid @ModelAttribute ("newIngredient") Ingredient ingredient,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "ingredient/create";
		}
		
		ingredientService.save(ingredient);
		
		
		
		return "redirect: /ingredient/index";
	}

}
