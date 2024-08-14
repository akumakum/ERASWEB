package com.eras.erasweb.service;


import com.eras.erasweb.dto.HospitalDTO;
import com.eras.erasweb.model.Hospital;

public interface HospitalService {
	Hospital ShowIfExist();
	void SaveHospital(HospitalDTO hospital);
	void UpdateHospital(HospitalDTO hospital, long hN);

}
