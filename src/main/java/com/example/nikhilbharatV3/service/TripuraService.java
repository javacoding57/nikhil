package com.example.nikhilbharatV3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.Tripura;
import com.example.nikhilbharatV3.repository.TripuraRepository;


@Service
public class TripuraService {

	@Autowired
	private TripuraRepository tripuraRepository;
	
	public void saveTripura(Tripura tripura) {
		tripuraRepository.save(tripura);	
	}

	public List<Tripura> getAllActiveImagesTripura() {
		return tripuraRepository.findAll();
	}

	public Optional<Tripura> getImageByIdTripura(Long id) {
		return tripuraRepository.findById(id);
	}

	public void deleteTripura(Long id) {
		tripuraRepository.deleteById(id);
		
	}

	public Tripura getTripura(Long id) {
		return tripuraRepository.findById(id).get();
	}
}

