package com.example.nikhilbharatV3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.TypAnyThingAndamanAndNicobarIslands;
import com.example.nikhilbharatV3.repository.TypAnyThingAndamanAndNicobarIslandsRepository;







@Service
public class TypAnyThingAndamanAndNicobarIslandsService {

//	@Autowired
//	private TypAnyThingAandNRepository typAnyThingAandNRepository;
//	
	
	@Autowired
	TypAnyThingAndamanAndNicobarIslandsRepository typAnyThingAndamanAndNicobarIslandsRepository;
	
	public void saveTypAnyThingAndamanAndNicobarIslands(TypAnyThingAndamanAndNicobarIslands typAnyThingAandN) {
		typAnyThingAndamanAndNicobarIslandsRepository.save(typAnyThingAandN);	
	}

	public List<TypAnyThingAndamanAndNicobarIslands> getAllActiveImages() {
		return typAnyThingAndamanAndNicobarIslandsRepository.findAll();
	}

	public Optional<TypAnyThingAndamanAndNicobarIslands> getImageById(Long id) {
		return typAnyThingAndamanAndNicobarIslandsRepository.findById(id);
	}

	public void delete(Long id) {
		typAnyThingAndamanAndNicobarIslandsRepository.deleteById(id);
		
	}

	public TypAnyThingAndamanAndNicobarIslands get(Long id) {
		return typAnyThingAndamanAndNicobarIslandsRepository.findById(id).get();
	}
}

