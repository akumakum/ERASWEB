package com.eras.erasweb.service.impl;

import com.eras.erasweb.dto.ComorbiditiesReferenceDTO;
import com.eras.erasweb.model.ComorbiditiesReference;
import com.eras.erasweb.model.User;
import com.eras.erasweb.repository.ComorbiditiesReferenceRepository;
import com.eras.erasweb.service.ComorbiditiesReferenceService;
import com.eras.erasweb.service.ComorbiditiesReferenceServiceMaint;
import com.eras.erasweb.utils.ModelToDtoDtoToModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComorbiditiesReferenceServiceMaintImpl implements ComorbiditiesReferenceServiceMaint {

	
	
    @Autowired
    private ComorbiditiesReferenceRepository repository;

    //@Autowired
    private ModelToDtoDtoToModel modelToDtoDtoToModel=new ModelToDtoDtoToModel();


    public List<ComorbiditiesReferenceDTO> getAllReferences() {
        return repository.findAll().stream()
                .map(modelToDtoDtoToModel::ComorbiditiesReferencetoDTO)
                .collect(Collectors.toList());
    }


    public ComorbiditiesReferenceDTO getReferenceById(long id) {
        ComorbiditiesReference entity = repository.findById(id).orElse(null);
        return modelToDtoDtoToModel.ComorbiditiesReferencetoDTO(entity);
    }



    public ComorbiditiesReferenceDTO createOrUpdateReference(ComorbiditiesReferenceDTO dto) {
    	dto.setCommorbidityId((long) 0); // to fix null on ID error
    	ComorbiditiesReference entity = modelToDtoDtoToModel.ComorbiditiesReferencetoEntity(dto);
        
        entity = repository.save(entity);
        return modelToDtoDtoToModel.ComorbiditiesReferencetoDTO(entity);
    }
    
    public ComorbiditiesReferenceDTO updateReference(ComorbiditiesReferenceDTO dto) {
        ComorbiditiesReference entity = modelToDtoDtoToModel.ComorbiditiesReferencetoEntity(dto);
        repository.findById(dto.getCommorbidityId())
        .ifPresent(comRef -> {
            comRef.setDescription(dto.getDescription());
            repository.save(comRef);
            
        });
        
        //repository.save(entity);
        return modelToDtoDtoToModel.ComorbiditiesReferencetoDTO(entity);
    }


    public void deleteReference(long id) {
        repository.deleteById(id);
    }
}
