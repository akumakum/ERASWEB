package com.eras.erasweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eras.erasweb.model.ComorbiditiesReference;
import com.eras.erasweb.repository.ComorbiditiesReferenceRepository;
import com.eras.erasweb.service.ComorbiditiesReferenceService;

import java.util.List;

@Service
public class ComorbiditiesReferenceServiceImpl implements ComorbiditiesReferenceService {



    @Autowired
    private ComorbiditiesReferenceRepository comorbiditiesReferenceRepository;

    public List<ComorbiditiesReference> findAll() {
    	
        return comorbiditiesReferenceRepository.findAll();
    }
    
    public ComorbiditiesReference findById(long id) {
        return comorbiditiesReferenceRepository.findById(id).orElse(null);
    }
}
 