package com.eras.erasweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eras.erasweb.dto.HospitalDTO;
import com.eras.erasweb.dto.MainPageURLDTO;
import com.eras.erasweb.model.Hospital;
import com.eras.erasweb.model.MainPageURL;
import com.eras.erasweb.repository.HospitalRepository;
import com.eras.erasweb.repository.MainPageURLRepository;
import com.eras.erasweb.service.MainPageURLService;
import com.eras.erasweb.utils.ModelToDtoDtoToModel;

@Service
public class MainPageURLServiceImpl implements MainPageURLService {

	private MainPageURLRepository mainPageURLRepository;
	private MainPageURLDTO mainPageURLDTO;
	
	private ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
	public MainPageURLServiceImpl(MainPageURLRepository mainPageURLRepository)
	{this.mainPageURLRepository= mainPageURLRepository;}	
	
	
	@Override
	public MainPageURL ShowIfExist() {
		long counter = mainPageURLRepository.count();
		MainPageURL mainPageURLrecord;
		if (counter != 0) {
			List<MainPageURL> mainPageURLList = mainPageURLRepository.findAll();
			mainPageURLrecord = mainPageURLList.get(0);

		} else {
			mainPageURLrecord = new MainPageURL();

		}

		return mainPageURLrecord;
	}

	@Override
	public void SaveMainPageURL(MainPageURLDTO mainPageURLDTO) {
		MainPageURL mainPageURL = modelConverter.mapToMainPageURLDTO(mainPageURLDTO );
		mainPageURLRepository.save(mainPageURL);

	}

	@Override
	public void UpdateMainPageURL(MainPageURLDTO mainPageURLDTO, long hN) {
		MainPageURL updatedMainPageURL = modelConverter.mapToMainPageURLDTO(mainPageURLDTO);
		Optional<MainPageURL> optionalmainPageURLDTO =mainPageURLRepository.findById(hN);
		if (optionalmainPageURLDTO.isPresent()) {
			MainPageURL mainPageURLDTO1 = optionalmainPageURLDTO.get();
			mainPageURLDTO1.setHospitalId(updatedMainPageURL.getHospitalId()); 
			mainPageURLDTO1.setHospitalCode(updatedMainPageURL.getHospitalCode());
			mainPageURLDTO1.setIntroURL(updatedMainPageURL.getIntroURL());
			mainPageURLDTO1.setGuideURL(updatedMainPageURL.getGuideURL());
			mainPageURLDTO1.setCreatedBy(updatedMainPageURL.getCreatedBy());
			mainPageURLDTO1.setDateCreated(updatedMainPageURL.getDateCreated());
			mainPageURLDTO1.setModifiedBy(updatedMainPageURL.getModifiedBy());
			mainPageURLDTO1.setDateUpdated(updatedMainPageURL.getDateUpdated());

			mainPageURLRepository.save(mainPageURLDTO1);
		}
		else {
            // Handle the case where the user does not exist
            throw new RuntimeException("User not found with ID: " + hN);
        }
		

	}

}
