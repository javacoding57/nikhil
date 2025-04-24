package com.example.nikhilbharatV3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.TypAnyThingAandN;
import com.example.nikhilbharatV3.repository.TypAnyThingAandNRepository;





@Service
public class TypAnyThingAandNService {

	@Autowired
	private TypAnyThingAandNRepository typAnyThingAandNRepository;
	
	public void saveAandN(TypAnyThingAandN typAnyThingAandN) {
		typAnyThingAandNRepository.save(typAnyThingAandN);	
	}

	public List<TypAnyThingAandN> getAllActiveImages() {
		return typAnyThingAandNRepository.findAll();
	}

	public Optional<TypAnyThingAandN> getImageById(Long id) {
		return typAnyThingAandNRepository.findById(id);
	}

	public void delete(Long id) {
		typAnyThingAandNRepository.deleteById(id);
		
	}

	public TypAnyThingAandN get(Long id) {
		return typAnyThingAandNRepository.findById(id).get();
	}
}

