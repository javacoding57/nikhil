package com.example.nikhilbharatV3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.WestBengal;
import com.example.nikhilbharatV3.repository.WestBengalRepository;


@Service
public class WestBengalService {

	@Autowired
	private WestBengalRepository westBengalRepository;
	
	public void saveWestBengal(WestBengal westBengal) {
		westBengalRepository.save(westBengal);	
	}

	public List<WestBengal> getAllActiveImagesWestBengal() {
		return westBengalRepository.findAll();
	}

	public Optional<WestBengal> getImageByIdWestBengal(Long id) {
		return westBengalRepository.findById(id);
	}

	public void deleteWestBengal(Long id) {
		westBengalRepository.deleteById(id);
		
	}

	public WestBengal getWestBengal(Long id) {
		return westBengalRepository.findById(id).get();
	}
}

