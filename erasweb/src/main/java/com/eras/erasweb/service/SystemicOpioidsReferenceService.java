package com.eras.erasweb.service;



import org.springframework.stereotype.Service;

import com.eras.erasweb.dto.SystemicOpioidsReferenceDTO;
import com.eras.erasweb.model.SystemicOpioidsReference;
import com.eras.erasweb.repository.ComorbiditiesReferenceRepository;

import java.util.List;

@Service
public interface SystemicOpioidsReferenceService {


	public List<SystemicOpioidsReference> findAll();
	public  SystemicOpioidsReference  findById(long id); 
	public  void  save(SystemicOpioidsReferenceDTO dto); 
	
}
