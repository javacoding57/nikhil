package com.example.nikhilbharatV3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.Bihar;
import com.example.nikhilbharatV3.repository.BiharRepository;








@Service
public class BiharService {

//	@Autowired
//	private TypAnyThingAandNRepository typAnyThingAandNRepository;
//	
	
	@Autowired
	BiharRepository biharRepository;
	
	public void saveBihar(Bihar typAnyThingAandN) {
		biharRepository.save(typAnyThingAandN);	
	}

	public List<Bihar> getAllActiveImagesBihar() {
		return biharRepository.findAll();
	}

	public Optional<Bihar> getImageByIdBihar(Long id) {
		return biharRepository.findById(id);
	}

	public void deleteBihar(Long id) {
		biharRepository.deleteById(id);
		
	}

	public Bihar getBihar(Long id) {
		return biharRepository.findById(id).get();
	}
}

