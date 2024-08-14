package com.eras.erasweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eras.erasweb.model.ComorbiditiesReference;

import java.util.List;

public interface ComorbiditiesReferenceRepository extends JpaRepository<ComorbiditiesReference, Long> {
    List<ComorbiditiesReference> findByDescriptionContainingIgnoreCase(String description);
    
}
