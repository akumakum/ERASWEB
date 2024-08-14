package com.eras.erasweb.utils;
import java.util.ArrayList;
import java.util.List;

import com.eras.erasweb.dto.*;

	public class ComorbiditiesDTOListWrapper {
	    private List<ComorbiditiesDTO> comorbiditiesDTOList;

	    public ComorbiditiesDTOListWrapper() {
	        this.comorbiditiesDTOList = new ArrayList<>();
	    }

	    public List<ComorbiditiesDTO> getComorbiditiesDTOList() {
	        return comorbiditiesDTOList;
	    }

	    public void setComorbiditiesDTOList(List<ComorbiditiesDTO> comorbiditiesDTOList) {
	        this.comorbiditiesDTOList = comorbiditiesDTOList;
	    }
	}


