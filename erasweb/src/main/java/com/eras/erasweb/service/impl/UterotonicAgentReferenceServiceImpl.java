package com.eras.erasweb.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eras.erasweb.dto.SystemicOpioidsReferenceDTO;
import com.eras.erasweb.dto.UterotonicAgentReferenceDTO;
import com.eras.erasweb.model.*;
import com.eras.erasweb.repository.UterotonicAgentReferenceRepository;

import com.eras.erasweb.service.*;
import com.eras.erasweb.utils.SystemicOpioidsReferenceConverter;
import com.eras.erasweb.utils.UterotonicAgentReferenceConverter;
@Service
public class UterotonicAgentReferenceServiceImpl implements UterotonicAgentReferenceService{

	public UterotonicAgentReferenceServiceImpl(UterotonicAgentReferenceRepository uterotonicAgentReferenceRepository) {
		super();
		this.uterotonicAgentReferenceRepository = uterotonicAgentReferenceRepository;
	}

	 @Autowired
	 private UterotonicAgentReferenceRepository uterotonicAgentReferenceRepository;
	
	 @Override
	public List<UterotonicAgentReference> findAll() {

		return uterotonicAgentReferenceRepository.findAll();
	}

	
	public UterotonicAgentReference findById(long id) {
		// TODO Auto-generated method stub
		return uterotonicAgentReferenceRepository.findById(id).orElse(null);
	}

	@Override
	public void save(UterotonicAgentReferenceDTO dto) {
		UterotonicAgentReference entity = UterotonicAgentReferenceConverter.dtoToEntity(dto);
		uterotonicAgentReferenceRepository.save(entity);
		
	}
}
