package com.example.nikhilbharatV3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.MP;
import com.example.nikhilbharatV3.repository.MadhyaPradeshRepository;


@Service
public class MadhyaPradeshService {

	@Autowired
	private MadhyaPradeshRepository madhyaPradeshRepository;
	
	public void saveMadhyaPradesh(MP mp) {
		madhyaPradeshRepository.save(mp);	
	}

	public List<MP> getAllActiveImagesMadhyaPradesh() {
		return madhyaPradeshRepository.findAll();
	}

	public Optional<MP> getImageByIdMadhyaPradesh(Long id) {
		return madhyaPradeshRepository.findById(id);
	}

	public void deleteMadhyaPradesh(Long id) {
		madhyaPradeshRepository.deleteById(id);
		
	}

	public MP getMadhyaPradesh(Long id) {
		return madhyaPradeshRepository.findById(id).get();
	}
}

