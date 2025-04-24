package com.example.nikhilbharatV3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.UP;
import com.example.nikhilbharatV3.repository.UpRepository;



@Service
public class UpService {

	@Autowired
	private UpRepository upRepository;
	
	public void saveUP(UP up) {
		upRepository.save(up);	
	}

	public List<UP> getAllActiveImagesUP() {
		return upRepository.findAll();
	}

	public Optional<UP> getImageByIdUP(Long id) {
		return upRepository.findById(id);
	}

	public void deleteUP(Long id) {
		upRepository.deleteById(id);
		
	}

	public UP getUP(Long id) {
		return upRepository.findById(id).get();
	}
}

