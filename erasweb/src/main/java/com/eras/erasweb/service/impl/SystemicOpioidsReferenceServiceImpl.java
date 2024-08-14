package com.eras.erasweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eras.erasweb.dto.SystemicOpioidsReferenceDTO;
import com.eras.erasweb.model.ComorbiditiesReference;
import com.eras.erasweb.model.OralOpioidsAgentsReference;
import com.eras.erasweb.model.SystemicOpioidsReference;
import com.eras.erasweb.repository.SystemicOpioidsReferenceRepository;
import com.eras.erasweb.service.SystemicOpioidsReferenceService;
import com.eras.erasweb.utils.OralOpioidsAgentsReferenceConverter;
import com.eras.erasweb.utils.SystemicOpioidsReferenceConverter;
@Service
public class SystemicOpioidsReferenceServiceImpl implements SystemicOpioidsReferenceService{

	 @Autowired
	 private SystemicOpioidsReferenceRepository systemicOpioidsReferenceRepository;
	
	 @Override
	public List<SystemicOpioidsReference> findAll() {

		return systemicOpioidsReferenceRepository.findAll();
	}


	public SystemicOpioidsReference findById(long id) {
		// TODO Auto-generated method stub
		return systemicOpioidsReferenceRepository.findById(id).orElse(null);
	}


	@Override
	public void save(SystemicOpioidsReferenceDTO dto) {
		SystemicOpioidsReference entity = SystemicOpioidsReferenceConverter.dtoToEntity(dto);
		systemicOpioidsReferenceRepository.save(entity);
		
	}
}
