package com.example.nikhilbharatV3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.UK;
import com.example.nikhilbharatV3.repository.UkRepository;


@Service
public class UKService {

	@Autowired
	private UkRepository ukRepository;
	
	public void saveUK(UK uk) {
		ukRepository.save(uk);	
	}

	public List<UK> getAllActiveImagesUK() {
		return ukRepository.findAll();
	}

	public Optional<UK> getImageByIdUK(Long id) {
		return ukRepository.findById(id);
	}

	public void deleteUK(Long id) {
		ukRepository.deleteById(id);
		
	}

	public UK getUK(Long id) {
		return ukRepository.findById(id).get();
	}
}

