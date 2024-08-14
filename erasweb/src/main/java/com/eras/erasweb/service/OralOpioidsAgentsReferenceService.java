package com.eras.erasweb.service;



import org.springframework.stereotype.Service;

import com.eras.erasweb.dto.OralOpioidsAgentsReferenceDTO;
import com.eras.erasweb.model.OralOpioidsAgentsReference;
import com.eras.erasweb.model.SystemicOpioidsReference;

import java.util.List;

@Service
public interface OralOpioidsAgentsReferenceService{
	public List<OralOpioidsAgentsReference> findAll();
	public List<OralOpioidsAgentsReferenceDTO> findAlldto();
	public  OralOpioidsAgentsReference  findById(long id); 
	public void save(OralOpioidsAgentsReferenceDTO dto);
	
}
