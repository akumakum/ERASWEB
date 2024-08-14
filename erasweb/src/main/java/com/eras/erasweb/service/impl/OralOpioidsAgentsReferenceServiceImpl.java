package com.eras.erasweb.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.eras.erasweb.dto.OralOpioidsAgentsReferenceDTO;
import com.eras.erasweb.model.*;
import com.eras.erasweb.repository.OralOpioidsAgentsReferenceRepository;
import com.eras.erasweb.repository.UterotonicAgentReferenceRepository;

import com.eras.erasweb.service.*;
import com.eras.erasweb.utils.OralOpioidsAgentsReferenceConverter;

@Service
public class OralOpioidsAgentsReferenceServiceImpl implements OralOpioidsAgentsReferenceService {
public OralOpioidsAgentsReferenceServiceImpl(
			OralOpioidsAgentsReferenceRepository oralOpioidsAgentsReferenceRepository) {
		super();
		this.oralOpioidsAgentsReferenceRepository = oralOpioidsAgentsReferenceRepository;
	}

@Autowired
	private OralOpioidsAgentsReferenceRepository oralOpioidsAgentsReferenceRepository;

	@Autowired
	private OralOpioidsAgentsReferenceRepository repository;
	
	@Override
	public List<OralOpioidsAgentsReference> findAll() {
		return oralOpioidsAgentsReferenceRepository.findAll();

	}

	@Override
	public OralOpioidsAgentsReference findById(long id) {

		return oralOpioidsAgentsReferenceRepository.findById(id).orElse(null);
	}

	@Override
	public List<OralOpioidsAgentsReferenceDTO> findAlldto() {
		  return OralOpioidsAgentsReferenceConverter.toDtoList(repository.findAll());
	
	}
	
	public void save(OralOpioidsAgentsReferenceDTO dto) {
        OralOpioidsAgentsReference entity = OralOpioidsAgentsReferenceConverter.toEntity(dto);
        repository.save(entity);
    }
	
}
