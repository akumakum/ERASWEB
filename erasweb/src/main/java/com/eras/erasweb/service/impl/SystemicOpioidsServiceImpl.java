package com.eras.erasweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eras.erasweb.model.SystemicOpioids;
import com.eras.erasweb.repository.SystemicOpioidsRepository;
import com.eras.erasweb.service.SystemicOpioidsService;
@Service
public class SystemicOpioidsServiceImpl implements SystemicOpioidsService {

	@Autowired
	private  SystemicOpioidsRepository systemicOpioidsRepository;
	@Override
	public void save(SystemicOpioids systemicOpioids) {
		systemicOpioidsRepository.save(systemicOpioids);
		
	}
	
	
}
