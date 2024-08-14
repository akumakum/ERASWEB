package com.eras.erasweb.service;

import java.util.List;

import com.eras.erasweb.dto.UserPositionDTO;
import com.eras.erasweb.dto.UserTypeDTO;
import com.eras.erasweb.model.UserPosition;
import com.eras.erasweb.model.UserPositionResponse;
import com.eras.erasweb.model.UserType;
import com.eras.erasweb.model.UserTypeResponse;

public interface UserPositionService {
	
	List<UserPositionDTO> SearchAllUserPosition();
	
	 UserPositionResponse ListAllUserPosition(int pageNo, int pageSize);
	// List<UserTypeDTO> SearchAllUserTypeByDesc();
	 UserPositionDTO SearchUserPositionByID(Long iduserPostition);
	 UserPosition SaveUserPosition(UserPositionDTO userPositionDTO);
	 Boolean DeactivateUserPosition();
	 void UpdateUserPosition(UserPositionDTO updatedUserposition,long userPositionID );
	
	
}
