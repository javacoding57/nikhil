package com.example.nikhilbharatV3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.Jharkhand;
import com.example.nikhilbharatV3.repository.JharkhandRepository;








@Service
public class JharkhandService {

	@Autowired
	private JharkhandRepository jharkhandRepository;
	
	public void saveJharkhand(Jharkhand jharkhand) {
		jharkhandRepository.save(jharkhand);	
	}

	public List<Jharkhand> getAllActiveImagesJharkhand() {
		return jharkhandRepository.findAll();
	}

	public Optional<Jharkhand> getImageByIdJharkhand(Long id) {
		return jharkhandRepository.findById(id);
	}

	public void deleteJharkhand(Long id) {
		jharkhandRepository.deleteById(id);
		
	}

	public Jharkhand getJharkhand(Long id) {
		return jharkhandRepository.findById(id).get();
	}
}

