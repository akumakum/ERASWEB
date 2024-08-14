package com.eras.erasweb.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.eras.erasweb.dto.HospitalDTO;
import com.eras.erasweb.model.Hospital;
import com.eras.erasweb.model.User;
import com.eras.erasweb.repository.HospitalRepository;
import com.eras.erasweb.service.HospitalService;
import com.eras.erasweb.utils.ModelToDtoDtoToModel;
@Service
public class HospitalServiceImpl implements HospitalService {
	private HospitalRepository hospitalRepository;
	private HospitalDTO hospitalDTO;
	private ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
	
	public HospitalServiceImpl(HospitalRepository hospitalRepository)
	{this.hospitalRepository= hospitalRepository;}
	@Override
	public Hospital ShowIfExist() {
		long counter=hospitalRepository.count();
		Hospital hospitalrecord;
		if(counter!=0) {
			List<Hospital> hospitalList =hospitalRepository.findAll();
			hospitalrecord= hospitalList.get(0);
		
		} else {
			 hospitalrecord=new Hospital();
			 
		}
		
		return hospitalrecord;
	}
	

	public void SaveHospital(HospitalDTO hospitalDTO) {
		Hospital hospital = modelConverter.mapToHospitalDTO(hospitalDTO);
		hospitalRepository.save(hospital);
		
	}
	@Override
	public void UpdateHospital(HospitalDTO hospital, long hN) {
		ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
		LocalDateTime today=LocalDateTime.now();
		//Hospital updatedHospital = modelConverter.mapToHospitalDTO(hospital);
		hospital.setHospitalID(hN);
		
		hospitalRepository.updateHospitalDetails(
	            hospital.getHospitalID(),
	            hospital.getAddress1(),
	            hospital.getAddress2(),
	            hospital.getAddress3(),
	            hospital.getAddress4(),
	            hospital.getCountry(),
	            hospital.getContactName(),
	            hospital.getContactPhone(),
	            hospital.getEmailAddress(),
	            hospital.getModifiedBy());
	}

}
