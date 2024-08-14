package com.eras.erasweb.service;

import java.util.List;

import com.eras.erasweb.dto.LoginDTO;
import com.eras.erasweb.dto.LoginResponseDTO;
import com.eras.erasweb.dto.UserDTO;
import com.eras.erasweb.model.User;
import com.eras.erasweb.model.UserResponse;

import org.springframework.data.domain.Page;


import java.util.List;
import java.util.Optional;



public interface UserService {
	 List<UserDTO> FindAllUsers();
	 
	 User SaveUser(UserDTO user);
	 
	 void AddUser(User user);

	 String DeleteUser(Long iduser);
	  
	 UserDTO SearchUserbyID(Long iduser);

	 //void UpdateUser(UserDTO user, long id);
	 void UpdateUser(UserDTO updatedUser,long userID );

	 UserResponse ListAllusers(int pageNo, int pageSize);

	 UserResponse ListAllByLastName(String lastname,int pageNo,int pageSize);

	 UserResponse ListAllByfirstName(String firstname, int pageNo,int pageSize);

	 Page<User> findPaginated(int pageNo, int pageSize);

	 List<UserDTO> SearchAllActivebyLastAndFirstName();
	 
	 Optional<User> FindbyUserDefinedID(String userDefinedID);
}
