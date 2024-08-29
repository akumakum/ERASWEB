package com.eras.erasweb.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eras.erasweb.dto.UserDTO;
import com.eras.erasweb.dto.UserPositionDTO;

import com.eras.erasweb.model.UserPosition;
import com.eras.erasweb.model.UserPositionResponse;


import com.eras.erasweb.repository.UserPositionRepository;

import com.eras.erasweb.service.UserPositionService;
import com.eras.erasweb.utils.ModelToDtoDtoToModel;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserPositionServiceImpl implements UserPositionService {
	private UserPositionRepository userPositionRepository;
	ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
	private UserPosition userPosition;
	private UserPositionDTO userPositionDTO;
	private LocalDateTime today = LocalDateTime.now();
	
	private ModelToDtoDtoToModel modelToDtoDtoToModel= new ModelToDtoDtoToModel();

public  UserPositionServiceImpl(UserPositionRepository userPositionRepository ) {
    this.userPositionRepository = userPositionRepository;


}

	@Override
	public List<UserPositionDTO> SearchAllUserPosition() {
		ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
		List<UserPosition> userPosition = userPositionRepository.findAll();
		return userPosition.stream().map(modelConverter::mapToUserPositionDTO).collect(Collectors.toList());
	}
	
	public List<UserPositionDTO> ListAllUserPositionCreated() {
		ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
		List<UserPosition> userPosition= userPositionRepository.findAll();
		return userPosition.stream().map(modelConverter::mapToUserPositionDTO).collect(Collectors.toList());
	
	
	}

@Override
	public UserPositionResponse ListAllUserPosition(int pageNo, int pageSize) {
		ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
		Pageable pageable =PageRequest.of(pageNo-1, pageSize);
		Page<UserPosition> userPosition = userPositionRepository.ListActiveUserPosition(pageable)  ;

		List<UserPosition> listOfUserPosition =userPosition.getContent();
		List<UserPositionDTO> content = listOfUserPosition.stream().map(modelConverter::mapToUserPositionDTO).collect(Collectors.toList());
		
		UserPositionResponse userPositionResponse = new UserPositionResponse();
		userPositionResponse.setContent(content);
		userPositionResponse.setPageNO(userPosition.getNumber());
		userPositionResponse.setPageSize(userPosition.getSize());
		userPositionResponse.setTotalElement(userPosition.getTotalElements());
		userPositionResponse.setTotalPages(userPosition.getTotalPages());
		userPositionResponse.setLast(userPosition.isLast());
		return userPositionResponse;
	
	}
	
	
	
	//@Override
	public UserPosition SaveUserPosition(UserPositionDTO userPositionDTO) {
		UserPosition userPosition = modelConverter.mapToUserPosition(userPositionDTO);
		userPositionRepository.saveAndFlush(userPosition);
		return null;
	}

	@Override
	public Boolean DeactivateUserPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPositionDTO SearchUserPositionByID(Long iduserType) {
		ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
		UserPosition userPosition = userPositionRepository.findById(iduserType).get();
		 return modelConverter.mapToUserPositionDTO(userPosition);
		
	}

	@Override
	public void UpdateUserPosition(UserPositionDTO userPosition, long userPositionID) {
		ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
		UserPosition updatedUserPosition = modelConverter.mapToUserPosition(userPosition);
        Optional<UserPosition> optionalUserPosition = userPositionRepository.findById(userPositionID);
        if (optionalUserPosition.isPresent()) {
            UserPosition existingUserPosition = optionalUserPosition.get();
            // Update the fields of existingUser with values from updatedUser
            existingUserPosition.setUserPostionDesc(updatedUserPosition.getUserPostionDesc());  
            existingUserPosition.setDateUpdated(today);
            existingUserPosition.setModifiedBy(updatedUserPosition.getModifiedBy());
            

            // Save the updated entity
            userPositionRepository.save(existingUserPosition);
        } else {
            // Handle the case where the user does not exist
            throw new RuntimeException("Position not found with ID: " + userPositionID);
        }
		
	}

	@Override
	public UserPositionDTO findById(long userPositionID) {
		
		UserPosition userPosition = userPositionRepository.findById(userPositionID)
		        .orElseThrow(() -> new EntityNotFoundException("UserPosition not found with ID: " + userPositionID));
		    
		    // Convert the UserPosition entity to a UserPositionDTO
		    return ModelToDtoDtoToModel.convertToUserPositionDTO(userPosition);
	}


	

}
