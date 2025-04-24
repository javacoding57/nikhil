package com.example.nikhilbharatV3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.Maharashtra;
import com.example.nikhilbharatV3.repository.MaharashtraRepository;










@Service
public class MaharashtraService {

	@Autowired
	private MaharashtraRepository maharashtraRepository;
	
	public void saveMaharashtra(Maharashtra maharashtra) {
		maharashtraRepository.save(maharashtra);	
	}

	public List<Maharashtra> getAllActiveImagesMaharashtra() {
		return maharashtraRepository.findAll();
	}

	public Optional<Maharashtra> getImageByIdMaharashtra(Long id) {
		return maharashtraRepository.findById(id);
	}

	public void deleteMaharashtra(Long id) {
		maharashtraRepository.deleteById(id);
		
	}

	public Maharashtra getMaharashtra(Long id) {
		return maharashtraRepository.findById(id).get();
	}
}

