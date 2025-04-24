package com.example.nikhilbharatV3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.Assam;
import com.example.nikhilbharatV3.repository.AssamRepository;
import com.example.nikhilbharatV3.repository.TypAnyThingAndamanAndNicobarIslandsRepository;
import com.example.nikhilbharatV3.repository.BiharRepository;

@Service
public class AssamService {

	@Autowired
	AssamRepository typAnyThingAndamanAndNicobarIslandsRepository;
	
	
	public void saveTypAnyThingAndamanAndNicobarIslands(Assam typAnyThingAandN) {
		typAnyThingAndamanAndNicobarIslandsRepository.save(typAnyThingAandN);	
	}

	public List<Assam> getAllActiveImages() {
		return typAnyThingAndamanAndNicobarIslandsRepository.findAll();
	}

	public Optional<Assam> getImageById(Long id) {
		return typAnyThingAndamanAndNicobarIslandsRepository.findById(id);
	}

	public void delete(Long id) {
		typAnyThingAndamanAndNicobarIslandsRepository.deleteById(id);
		
	}

	public Assam get(Long id) {
		return typAnyThingAndamanAndNicobarIslandsRepository.findById(id).get();
	}
	
}
