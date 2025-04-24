package com.example.nikhilbharatV3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.nikhilbharatV3.model.Job;



public interface JobRepository extends JpaRepository<Job, Long> {
		
	@Query("SELECT j FROM Job j WHERE CONCAT(j.applicationid, ' ',j.jobdesignation, ' ', j.department, ' ', j.salary, ' ', j.location,' ', j.noticepriod,' ', j.jobtype,' ', j.jobdescription) LIKE %?1%")
	public List<Job> search(String keyword);
	
//	Optional<Product> findById(long id);
	
}