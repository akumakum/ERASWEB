package com.eras.erasweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eras.erasweb.model.ComorbiditiesReference;
import com.eras.erasweb.repository.ComorbiditiesReferenceRepository;

import java.util.List;

@Service
public interface ComorbiditiesReferenceService {

	public ComorbiditiesReference findById(long id);
	public List<ComorbiditiesReference> findAll();
	//public List<ComorbiditiesReference> find
}
