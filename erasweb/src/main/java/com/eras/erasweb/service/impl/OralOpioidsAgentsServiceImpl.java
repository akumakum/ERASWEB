package com.eras.erasweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eras.erasweb.model.OralOpioidsAgents;
import com.eras.erasweb.repository.OralOpioidsAgentsRepository;
import com.eras.erasweb.service.OralOpioidsAgentsService;
@Service
public class OralOpioidsAgentsServiceImpl implements OralOpioidsAgentsService {

	@Autowired
	public OralOpioidsAgentsRepository  oralOpioidsAgentsRepository;
	
	@Override
	public void save(OralOpioidsAgents oralOpioidsAgents) {
		// TODO Auto-generated method stub
		oralOpioidsAgentsRepository.save(oralOpioidsAgents);
	}

}
