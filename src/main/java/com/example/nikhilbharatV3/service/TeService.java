package com.example.nikhilbharatV3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.Te;
import com.example.nikhilbharatV3.repository.TeRepository;



@Service
public class TeService {

	@Autowired
	private TeRepository teRepository;
	
	public void saveTe(Te te) {
		teRepository.save(te);	
	}

	public List<Te> getAllActiveImagesTe() {
		return teRepository.findAll();
	}

	public Optional<Te> getImageByIdTe(Long id) {
		return teRepository.findById(id);
	}

	public void deleteTe(Long id) {
		teRepository.deleteById(id);
		
	}

	public Te getTe(Long id) {
		return teRepository.findById(id).get();
	}
}

