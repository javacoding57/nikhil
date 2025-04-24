package com.example.nikhilbharatV3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nikhilbharatV3.model.MP;

@Repository
public interface MadhyaPradeshRepository extends JpaRepository<MP, Long> {

}
