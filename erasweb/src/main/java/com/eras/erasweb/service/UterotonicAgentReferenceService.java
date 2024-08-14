package com.eras.erasweb.service;



import org.springframework.stereotype.Service;

import com.eras.erasweb.dto.UterotonicAgentReferenceDTO;
import com.eras.erasweb.model.UterotonicAgentReference;
import com.eras.erasweb.repository.*;


import java.util.List;
import java.util.Optional;

@Service
public interface UterotonicAgentReferenceService {


	public List<UterotonicAgentReference> findAll();
	
	public UterotonicAgentReference findById(long id);

	void save(UterotonicAgentReferenceDTO dto);
}
