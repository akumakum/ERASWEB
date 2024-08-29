
package com.eras.erasweb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eras.erasweb.model.UserPosition;

@Repository
public interface UserPositionRepository extends JpaRepository <UserPosition,Long >{

	@Query("SELECT u from UserPosition u WHERE u.userPositionID <> 0  ORDER BY u.userPostionDesc") 
	Page<UserPosition> ListActiveUserPosition(Pageable pageable);


}
