package com.example.nikhilbharatV3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.Karnataka;
import com.example.nikhilbharatV3.repository.KarnatakaRepository;









@Service
public class KarnatakaService {

	@Autowired
	private KarnatakaRepository karnatakaRepository;
	
	public void saveKarnataka(Karnataka karnataka) {
		karnatakaRepository.save(karnataka);	
	}

	public List<Karnataka> getAllActiveImagesKarnataka() {
		return karnatakaRepository.findAll();
	}

	public Optional<Karnataka> getImageByIdKarnataka(Long id) {
		return karnatakaRepository.findById(id);
	}

	public void deleteKarnataka(Long id) {
		karnatakaRepository.deleteById(id);
		
	}

	public Karnataka getKarnataka(Long id) {
		return karnatakaRepository.findById(id).get();
	}
}

