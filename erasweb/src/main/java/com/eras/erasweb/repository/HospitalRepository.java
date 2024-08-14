package com.eras.erasweb.repository;
import com.eras.erasweb.dto.HospitalDTO;
import com.eras.erasweb.model.*;

import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long>{

	@Query("SELECT u from Hospital u WHERE u.hospitalID>0") 
	Optional<HospitalDTO> ShowifExist();
	
	   @Modifying
	    @Transactional
	    @Query("UPDATE Hospital h SET h.address1 = :address1, h.address2 = :address2, h.address3 = :address3, h.address4 = :address4, " +
	            "h.country = :country, h.contactName = :contactName, h.contactPhone = :contactPhone, h.emailAddress = :emailAddress, " +
	            "h.modifiedBy = :modifiedBy, h.dateUpdated = CURRENT_TIMESTAMP WHERE h.hospitalID = :hospitalID")
	    int updateHospitalDetails(@Param("hospitalID") long hospitalID,
	                              @Param("address1") String address1,
	                              @Param("address2") String address2,
	                              @Param("address3") String address3,
	                              @Param("address4") String address4,
	                              @Param("country") String country,
	                              @Param("contactName") String contactName,
	                              @Param("contactPhone") String contactPhone,
	                              @Param("emailAddress") String emailAddress,
	                              @Param("modifiedBy") String modifiedBy);
}