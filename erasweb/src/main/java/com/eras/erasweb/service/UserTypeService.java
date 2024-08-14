package com.eras.erasweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eras.erasweb.dto.UserDTO;
import com.eras.erasweb.dto.UserTypeDTO;
import com.eras.erasweb.model.UserResponse;
import com.eras.erasweb.model.UserType;
import com.eras.erasweb.model.UserTypeResponse;
@Service
public interface UserTypeService {
	

	List <UserTypeDTO> ListAllUserTypeCreated();
	
	 UserTypeResponse ListAllUserTypes(int pageNo, int pageSize);
	// List<UserTypeDTO> SearchAllUserTypeByDesc();
	 UserTypeDTO SearchUserTypebyID(Long iduserType);
	 UserType SaveUseType(UserTypeDTO userTypeDTO);
	 Boolean DeactivateUserType();
	 void UpdateUserType(UserTypeDTO updatedUsertype,long userTypeID );
	 
}
