package com.eras.erasweb.service.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eras.erasweb.dto.LoginDTO;
import com.eras.erasweb.dto.LoginResponseDTO;
import com.eras.erasweb.dto.UserDTO;
import com.eras.erasweb.dto.UserPositionDTO;
import com.eras.erasweb.dto.UserTypeDTO;
import com.eras.erasweb.utils.ModelToDtoDtoToModel;
import com.eras.erasweb.model.User;
import com.eras.erasweb.model.UserPosition;
import com.eras.erasweb.model.UserResponse;
import com.eras.erasweb.service.UserService;
import com.eras.erasweb.repository.*;
@Service


public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	private ModelToDtoDtoToModel modelConverter= new ModelToDtoDtoToModel();
	public UserServiceImpl (UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	@Override
	public List<UserDTO> FindAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public User SaveUser(UserDTO userDTO) {
		User user = modelConverter.mapToUserDTO(userDTO);
		user.setPassword(passwordEncoder.encode(user.getPassword()) );
		userRepository.saveAndFlush(user);
		return null;
	}

	@Override
	public String DeleteUser(Long iduser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO SearchUserbyID(Long userID) {
		ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
		User user = userRepository.findById(userID).get();
		 return modelConverter.mapToUser(user);
		
	}

	@Override
	public
	void UpdateUser(UserDTO user,long userID ) {
		ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
		User updatedUser = modelConverter.mapToUserDTO(user);
		user.setPassword(passwordEncoder.encode(user.getPassword()) );
        Optional<User> optionalUser = userRepository.findById(userID);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            // Update the fields of existingUser with values from updatedUser
            existingUser.setUserDefinedID(updatedUser.getUserDefinedID());
            existingUser.setEmailAdd(updatedUser.getEmailAdd());
            existingUser.setFullName(updatedUser.getFullName());
            existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            existingUser.setSalt(updatedUser.getSalt());
            existingUser.setUserTypeID(updatedUser.getUserTypeID());
            existingUser.setUserTypeDesc(updatedUser.getUserTypeDesc());
            existingUser.setPosition(updatedUser.getPosition());
            existingUser.setHospitalCode(updatedUser.getHospitalCode());
            existingUser.setHospitalId(updatedUser.getHospitalId());
            existingUser.setIsInactive(updatedUser.getIsInactive());
            existingUser.setModifiedBy(updatedUser.getModifiedBy());
            // Save the updated entity
            userRepository.save(existingUser);
        } else {
            // Handle the case where the user does not exist
            throw new RuntimeException("User not found with ID: " + userID);
        }
    }
	
	@Override
	public UserResponse ListAllusers(int pageNo, int pageSize) {
		ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
		Pageable pageable =PageRequest.of(pageNo-1, pageSize);
		Page<User> users = userRepository.ListActiveUsers(pageable);
		//Page<User> users = userRepository.ListActiveUsers2(pageable);
		List<User> listOfUser=users.getContent();
		List<UserDTO> content = listOfUser.stream().map(modelConverter::mapToUser).collect(Collectors.toList());
		
//		List<UserPosition> userPosition = userPositionRepository.findAll();
//		return userPosition.stream().map(modelConverter::mapToUserPositionDTO).collect(Collectors.toList());	
 
		
		UserResponse userResponse = new UserResponse();
		userResponse.setContent(content);
		userResponse.setPageNO(users.getNumber());
		userResponse.setPageSize(users.getSize());
		userResponse.setTotalElement(users.getTotalElements());
		userResponse.setTotalPages(users.getTotalPages());
		userResponse.setLast(users.isLast());
		return userResponse;
	
	}

	@Override
	public UserResponse ListAllByLastName(String lastname,int pageNo,int pageSize) {
		Pageable pageable =PageRequest.of(pageNo-1, pageSize); 
		//Page<User> users = userRepository.ListActiveUsers(pageable);
		Page<User> users = userRepository.ListActiveUsersByLastName(lastname,pageable);
		List<User> listOfUser=users.getContent();
		List<UserDTO> content = listOfUser.stream().map(modelConverter::mapToUser).collect(Collectors.toList());
		
		UserResponse userResponse = new UserResponse();
		userResponse.setContent(content);
		userResponse.setPageNO(users.getNumber());
		userResponse.setPageSize(users.getSize());
		userResponse.setTotalElement(users.getTotalElements());
		userResponse.setTotalPages(users.getTotalPages());
		userResponse.setLast(users.isLast());
		return userResponse;
	}
	@Override
	public UserResponse ListAllByfirstName(String firstname, int pageNo, int pageSize) {
		
		Pageable pageable =PageRequest.of(pageNo-1, pageSize); 
		Page<User> users = userRepository.ListActiveUsersByfirstName(firstname,pageable);
		List<User> listOfUser=users.getContent();
		List<UserDTO> content = listOfUser.stream().map(modelConverter::mapToUser).collect(Collectors.toList());
		
	
		UserResponse userResponse = new UserResponse();
		userResponse.setContent(content);
		userResponse.setPageNO(users.getNumber());
		userResponse.setPageSize(users.getSize());
		userResponse.setTotalElement(users.getTotalElements());
		userResponse.setTotalPages(users.getTotalPages());
		userResponse.setLast(users.isLast());
		
		return userResponse;

	}

	@Override
	public Page<User> findPaginated(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> SearchAllActivebyLastAndFirstName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void AddUser(User user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Optional<User> FindbyUserDefinedID(String userDefinedID) {
		
		return userRepository.findByUserDefinedID(userDefinedID);
	}

	

}
