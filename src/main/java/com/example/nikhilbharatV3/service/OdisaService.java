package com.example.nikhilbharatV3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.Odisa;
import com.example.nikhilbharatV3.repository.OdisaRepository;


@Service
public class OdisaService {

	@Autowired
	private OdisaRepository odisaRepository;
	
	public void saveOdisa(Odisa odisa) {
		odisaRepository.save(odisa);	
	}

	public List<Odisa> getAllActiveImagesOdisa() {
		return odisaRepository.findAll();
	}

	public Optional<Odisa> getImageByIdOdisa(Long id) {
		return odisaRepository.findById(id);
	}

	public void deleteOdisa(Long id) {
		odisaRepository.deleteById(id);
		
	}

	public Odisa getOdisa(Long id) {
		return odisaRepository.findById(id).get();
	}
}

