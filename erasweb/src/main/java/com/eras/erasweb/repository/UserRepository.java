package com.eras.erasweb.repository;
import com.eras.erasweb.dto.LoginResponseDTO;
import com.eras.erasweb.model.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	@Query("SELECT u from User u WHERE u.isInactive=false OR u.isInactive=true  ORDER By u.fullName ") 
	Page<User> ListActiveUsers(Pageable pageable);

	@Query("SELECT u from User u WHERE  u.UserDefinedID = :userdefinedID ") 
	Optional<User> findByUserDefinedID(String userdefinedID);
	
//	@Query(value = 
//			"SELECT u.user_typeid,u.user_type_desc as x,u.modified_by,u.email_add,u.password,u.salt,u.date_updated,u.hospital_code,u.hospital_id,u.userid,u.full_Name,u.user_DefinedID,u.position,u.is_Inactive,u.created_By,u.date_Created,ut.user_Type_Desc as userTypeDesc FROM users u INNER JOIN user_type ut ON u.user_TypeID = ut.user_TypeID", nativeQuery = true)
//	Page<User> ListActiveUsers2(Pageable pageable);
//	
	
	@Query("SELECT u from User u WHERE  UPPER(u.UserDefinedID) LIKE UPPER(CONCAT ('%',:lastname,'%' )) ORDER By u.UserDefinedID ")
	Page<User> ListActiveUsersByLastName(String lastname, Pageable peageable);
//
//
	@Query("SELECT u from User u WHERE  UPPER(u.fullName) LIKE UPPER(CONCAT ('%',:fullName,'%' )) ORDER By u.fullName")
	Page<User> ListActiveUsersByfirstName(String fullName,Pageable peageable);
//
//


}
