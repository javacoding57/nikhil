package com.example.nikhilbharatV3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.Chhattisgarh;
import com.example.nikhilbharatV3.repository.ChhattisgarhRepository;






@Service
public class ChhattisgarhService {

	@Autowired
	private ChhattisgarhRepository chhattisgarhRepository;
	
	public void saveChhattisgarh(Chhattisgarh chhattisgarh) {
		chhattisgarhRepository.save(chhattisgarh);	
	}

	public List<Chhattisgarh> getAllActiveImagesChhattisgarh() {
		return chhattisgarhRepository.findAll();
	}

	public Optional<Chhattisgarh> getImageByIdChhattisgarh(Long id) {
		return chhattisgarhRepository.findById(id);
	}

	public void deleteChhattisgarh(Long id) {
		chhattisgarhRepository.deleteById(id);
		
	}

	public Chhattisgarh getChhattisgarh(Long id) {
		return chhattisgarhRepository.findById(id).get();
	}
}

