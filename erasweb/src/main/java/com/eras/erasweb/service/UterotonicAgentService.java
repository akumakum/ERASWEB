package com.eras.erasweb.service;



import org.springframework.stereotype.Service;

import com.eras.erasweb.model.SystemicOpioidsReference;
import com.eras.erasweb.model.UterotonicAgent;
import com.eras.erasweb.repository.ComorbiditiesReferenceRepository;

import java.util.List;

@Service
public interface UterotonicAgentService {


	public List<UterotonicAgent> findAll();
	
	public  UterotonicAgent  findById(long id);
	
	public void save(UterotonicAgent uterotonicAgent);
	
}
