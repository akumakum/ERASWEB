package com.eras.erasweb.service.impl;

import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.eras.erasweb.dto.UserDTO;
import com.eras.erasweb.dto.UserTypeDTO;
import com.eras.erasweb.model.User;
import com.eras.erasweb.model.UserType;
import com.eras.erasweb.model.UserTypeResponse;
import com.eras.erasweb.repository.UserTypeRepository;
import com.eras.erasweb.service.UserTypeService;
import com.eras.erasweb.utils.*;


@Service
public class UserTypeServiceImpl implements UserTypeService{
	private ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
	private UserTypeRepository userTypeRepository;
	private UserTypeDTO userTypeDTO;
	private LocalDateTime today =LocalDateTime.now(); 
	
	public UserTypeServiceImpl(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }
    
	public List<UserTypeDTO> ListAllUserTypeCreated() {
		ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
		List<UserType> userType=userTypeRepository.findAll();
		return userType.stream().map(modelConverter::mapToUserTypeDTO).collect(Collectors.toList());
	
	
	}


	@Override
	public UserTypeResponse ListAllUserTypes(int pageNo, int pageSize) {
		ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
		Pageable pageable =PageRequest.of(pageNo-1, pageSize);
		Page<UserType> userTypes = userTypeRepository.ListActiveUserTypes(pageable);

		List<UserType> listOfUserTypes =userTypes.getContent();
		List<UserTypeDTO> content = listOfUserTypes.stream().map(modelConverter::mapToUserTypeDTO).collect(Collectors.toList());
		
		UserTypeResponse userTypeResponse = new UserTypeResponse();
		userTypeResponse.setContent(content);
		userTypeResponse.setPageNO(userTypes.getNumber());
		userTypeResponse.setPageSize(userTypes.getSize());
		userTypeResponse.setTotalElement(userTypes.getTotalElements());
		userTypeResponse.setTotalPages(userTypes.getTotalPages());
		userTypeResponse.setLast(userTypes.isLast());
		return userTypeResponse;
	
	}
	
	
	
	//@Override
	public UserType SaveUseType(UserTypeDTO userTypeDTO) {
		UserType userType = modelConverter.mapToUserType(userTypeDTO);
		userTypeRepository.saveAndFlush(userType);
		return null;
	}

	@Override
	public Boolean DeactivateUserType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserTypeDTO SearchUserTypebyID(Long iduserType) {
		ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
		UserType userType = userTypeRepository.findById(iduserType).get();
		 return modelConverter.mapToUserTypeDTO(userType);
		
	}

	@Override
	public void UpdateUserType(UserTypeDTO userType, long userTypeID) {
		ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
		UserType updatedUserType = modelConverter.mapToUserType(userType);
        Optional<UserType> optionalUserType = userTypeRepository.findById(userTypeID);
        if (optionalUserType.isPresent()) {
            UserType existingUserType = optionalUserType.get();
            // Update the fields of existingUser with values from updatedUser
            existingUserType.setUserTypeCode(updatedUserType.getUserTypeCode());
            existingUserType.setUserTypeDesc(updatedUserType.getUserTypeDesc());
            existingUserType.setDateUpdated(today);
            existingUserType.setModifiedBy(updatedUserType.getModifiedBy());
            

            // Save the updated entity
            userTypeRepository.save(existingUserType);
        } else {
            // Handle the case where the user does not exist
            throw new RuntimeException("User not found with ID: " + userTypeID);
        }
		
	}


}
