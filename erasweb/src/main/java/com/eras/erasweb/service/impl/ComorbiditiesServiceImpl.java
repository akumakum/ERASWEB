package com.eras.erasweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eras.erasweb.model.Comorbidities;
import com.eras.erasweb.repository.ComorbiditiesRepository;
import com.eras.erasweb.service.ComorbiditiesService;
@Service
public class ComorbiditiesServiceImpl implements ComorbiditiesService  {

	private Comorbidities comorbidities;
	@Autowired
	private ComorbiditiesRepository comorbititiesRepository;
	
	@Override
	public void save() {
		comorbititiesRepository.save(comorbidities);
		
	}

	@Override
	public void save(Comorbidities comorbidities) {
		comorbititiesRepository.save(comorbidities);
		
	}

	@Override
	public void delete(Comorbidities comorbidities) {
		comorbititiesRepository.delete(comorbidities);
		
	}

}
