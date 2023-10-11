package org.java.db.service;

import java.util.List;

import org.java.db.pojo.SpecialOffer;
import org.java.db.repo.SpecialOfferRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class SpecialOfferService {

	@Autowired
	private SpecialOfferRepo specialOfferRepo;
	
	public void save(SpecialOffer specialOffer) {
		
		specialOfferRepo.save(specialOffer);
	}
	
	public List<SpecialOffer> findAll(){
		
		return specialOfferRepo.findAll();
	}
	
	public SpecialOffer findById(int id) {
		
		return specialOfferRepo.findById(id).get();
	}
	
}
