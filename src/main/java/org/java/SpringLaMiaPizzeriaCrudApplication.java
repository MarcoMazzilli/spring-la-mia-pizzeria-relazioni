package org.java;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.java.db.pojo.Pizza;
import org.java.db.pojo.SpecialOffer;
import org.java.db.service.PizzaService;
import org.java.db.service.SpecialOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private SpecialOfferService spService;


	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String imgPizza = "https://images.pexels.com/photos/10790638/pexels-photo-10790638.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1";


		List<Pizza> arrayPizze = Arrays.asList(
				new Pizza("margherita", "La regina delle pizze", imgPizza, 5.50),
				new Pizza("diavola", "La piccantissima", imgPizza, 6.50),
				new Pizza("ananas", "L'insulto gravissimo", imgPizza, 0.50),
				new Pizza("ananas", "L'insulto gravissimo", imgPizza, 0.50),
				new Pizza("funghi e prosciutto", "La regina delle pizze", imgPizza, 5.50),
				new Pizza("vegetariana", "La piccantissima", imgPizza, 6.50),
				new Pizza("capricciosa ", "L'insulto gravissimo", imgPizza, 0.50),
				new Pizza("napoletana", "La regina delle pizze", imgPizza, 5.50),
				new Pizza("senza lattosio", "La piccantissima", imgPizza, 6.50),
				new Pizza("gourmet", "L'insulto gravissimo", imgPizza, 0.50)
				);

		arrayPizze.forEach(p -> pizzaService.save(p));
		Pizza p1 = new Pizza("Test oneToMany", "tesTest", imgPizza, 8.00);
		pizzaService.save(p1);
		
		SpecialOffer sp1 = new SpecialOffer(LocalDate.now(), LocalDate.parse("2024-01-01"), "Offerta della settimana",p1);
		spService.save(sp1);


		System.out.println("Salvataggio dell'elemento andato a buon fine");

	}

}
