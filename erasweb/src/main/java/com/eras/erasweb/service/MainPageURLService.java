package com.eras.erasweb.service;


import com.eras.erasweb.dto.MainPageURLDTO;
import com.eras.erasweb.model.MainPageURL;

public interface MainPageURLService {
	MainPageURL ShowIfExist();
	void SaveMainPageURL(MainPageURLDTO mainPageURLDTO);
	void UpdateMainPageURL(MainPageURLDTO mainPageURLDTO, long hN);
}
