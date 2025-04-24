package com.example.nikhilbharatV3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.Gujrat;
import com.example.nikhilbharatV3.repository.GujratRepository;







@Service
public class GujratService {

	@Autowired
	private GujratRepository gujratRepository;
	
	public void saveGujrat(Gujrat gujrat) {
		gujratRepository.save(gujrat);	
	}

	public List<Gujrat> getAllActiveImagesGujrat() {
		return gujratRepository.findAll();
	}

	public Optional<Gujrat> getImageByIdGujrat(Long id) {
		return gujratRepository.findById(id);
	}

	public void deleteGujrat(Long id) {
		gujratRepository.deleteById(id);
		
	}

	public Gujrat getGujrat(Long id) {
		return gujratRepository.findById(id).get();
	}
}

