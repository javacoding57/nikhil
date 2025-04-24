package com.example.nikhilbharatV3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.Delhi;
import com.example.nikhilbharatV3.repository.DelhiRepository;







@Service
public class DelhiService {

	@Autowired
	private DelhiRepository delhiRepository;
	
	public void saveDelhi(Delhi delhi) {
		delhiRepository.save(delhi);	
	}

	public List<Delhi> getAllActiveImagesDelhi() {
		return delhiRepository.findAll();
	}

	public Optional<Delhi> getImageByIdDelhi(Long id) {
		return delhiRepository.findById(id);
	}

	public void deleteDelhi(Long id) {
		delhiRepository.deleteById(id);
		
	}

	public Delhi getDelhi(Long id) {
		return delhiRepository.findById(id).get();
	}
}

