package org.java.db.pojo;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Past;

@Entity
public class SpecialOffer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private LocalDate startDate;
	
	@Column(nullable = false)
	@Past
	private LocalDate expirationDate;
	
	@Column(nullable = false)
	@Length(min = 1, max= 255 , message = "Length must be from 1 to 255 character")
	private String title;
	
	@ManyToOne
	@Column(nullable = false)
	private Pizza pizza;
	
	public SpecialOffer() {};
	public SpecialOffer(LocalDate startDate,LocalDate expirationDate,String title) {
		
		setStartDate(startDate);
		setExpirationDate(expirationDate);
		setTitle(title);
	};
	
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	// GET ~ SET Pizza
	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public String toString() {
		return "Title : " + getTitle() +
				"StartDate : " + getStartDate() +
				"ExpirationDate" + getExpirationDate();
	}
}
