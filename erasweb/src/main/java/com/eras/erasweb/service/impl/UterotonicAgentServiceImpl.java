package com.eras.erasweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eras.erasweb.model.ComorbiditiesReference;
import com.eras.erasweb.model.SystemicOpioidsReference;
import com.eras.erasweb.model.UterotonicAgent;
import com.eras.erasweb.repository.SystemicOpioidsReferenceRepository;
import com.eras.erasweb.repository.UterotonicAgentRepository;
import com.eras.erasweb.service.SystemicOpioidsReferenceService;
import com.eras.erasweb.service.UterotonicAgentService;
@Service
public class UterotonicAgentServiceImpl implements UterotonicAgentService{

	 @Autowired
	 private UterotonicAgentRepository uterotonicAgentRepository;
	
	 @Override
	public List<UterotonicAgent> findAll() {

		return uterotonicAgentRepository.findAll();
	}


	public UterotonicAgent findById(long id) {
		// TODO Auto-generated method stub
		return uterotonicAgentRepository.findById(id).orElse(null);
	}
//	public ComorbiditiesReference findById(long id) {
//        return comorbiditiesReferenceRepository.findById(id).orElse(null);
//    }


	@Override
	public void save(UterotonicAgent uterotonicAgent) {
		uterotonicAgentRepository.save(uterotonicAgent);
		
	}
}
