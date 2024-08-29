package com.eras.erasweb.utils;

import com.eras.erasweb.dto.UserDTO;
import com.eras.erasweb.dto.UserPositionDTO;
import com.eras.erasweb.dto.UserTypeDTO;
import com.eras.erasweb.model.User;
import com.eras.erasweb.model.UserPosition;
import com.eras.erasweb.model.UserType;

public class EntityToDtoConverter {

    public static UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserID(user.getUserID());
        userDTO.setUserDefinedID(user.getUserDefinedID());
        userDTO.setEmailAdd(user.getEmailAdd());
        userDTO.setFullName(user.getFullName());
        userDTO.setHospitalCode(user.getHospitalCode());
        userDTO.setHospitalId(user.getHospitalId());
        userDTO.setIsInactive(user.getIsInactive());
        userDTO.setDateCreated(user.getDateCreated());
        userDTO.setDateUpdated(user.getDateUpdated());
        userDTO.setCreatedBy(user.getCreatedBy());
        userDTO.setModifiedBy(user.getModifiedBy());
        userDTO.setUserTypes(convertToUserTypeDTO(user.getUserTypes()));
        userDTO.setUserPositions(convertToUserPositionDTO(user.getUserPositions()));
        userDTO.setSalt(user.getSalt());
        userDTO.setConfirmPassword(user.getConfirmPassword());
        return userDTO;
    }
    
    public static User convertToUserEntity(UserDTO userDTO) {
        User user = new User();
        user.setUserID(userDTO.getUserID());
        user.setUserDefinedID(userDTO.getUserDefinedID());
        user.setEmailAdd(userDTO.getEmailAdd());
        user.setFullName(userDTO.getFullName());
        user.setHospitalCode(userDTO.getHospitalCode());
        user.setHospitalId(userDTO.getHospitalId());
        user.setIsInactive(userDTO.getIsInactive());
        user.setDateCreated(userDTO.getDateCreated());
        user.setDateUpdated(userDTO.getDateUpdated());
        user.setCreatedBy(userDTO.getCreatedBy());
        user.setModifiedBy(userDTO.getModifiedBy());
        user.setUserTypes(convertToUserTypeEntity(userDTO.getUserTypes()));
        user.setUserPositions(convertToUserPositionEntity(userDTO.getUserPositions()));
        user.setSalt(userDTO.getSalt());
        user.setPassword(userDTO.getPassword());  // Ensure you handle this correctly
        return user;
    }


    public static UserTypeDTO convertToUserTypeDTO(UserType userType) {
        UserTypeDTO userTypeDTO = new UserTypeDTO();
        userTypeDTO.setUserTypeID(userType.getUserTypeID());
        userTypeDTO.setUserTypeDesc(userType.getUserTypeDesc());
        userTypeDTO.setUserTypeCode(userType.getUserTypeCode());
        userTypeDTO.setDateCreated(userType.getDateCreated());
        userTypeDTO.setDateUpdated(userType.getDateUpdated());
        userTypeDTO.setCreatedBy(userType.getCreatedBy());
        userTypeDTO.setModifiedBy(userType.getModifiedBy());
        return userTypeDTO;
    }
    
    public static UserType convertToUserTypeEntity(UserTypeDTO userTypeDTO) {
        UserType userType = new UserType();
        userType.setUserTypeID(userTypeDTO.getUserTypeID());
        userType.setUserTypeDesc(userTypeDTO.getUserTypeDesc());
        userType.setUserTypeCode(userTypeDTO.getUserTypeCode());
        userType.setDateCreated(userTypeDTO.getDateCreated());
        userType.setDateUpdated(userTypeDTO.getDateUpdated());
        userType.setCreatedBy(userTypeDTO.getCreatedBy());
        userType.setModifiedBy(userTypeDTO.getModifiedBy());
        return userType;
    }

    public static UserPositionDTO convertToUserPositionDTO(UserPosition userPosition) {
        UserPositionDTO userPositionDTO = new UserPositionDTO();
        userPositionDTO.setUserPositionID(userPosition.getUserPositionID());
        userPositionDTO.setUserPostionDesc(userPosition.getUserPostionDesc());
        userPositionDTO.setDateCreated(userPosition.getDateCreated());
        userPositionDTO.setDateUpdated(userPosition.getDateUpdated());
        userPositionDTO.setCreatedBy(userPosition.getCreatedBy());
        userPositionDTO.setModifiedBy(userPosition.getModifiedBy());
        return userPositionDTO;
    }
    public static UserPosition convertToUserPositionEntity(UserPositionDTO userPositionDTO) {
        UserPosition userPosition = new UserPosition();
        userPosition.setUserPositionID(userPositionDTO.getUserPositionID());
        userPosition.setUserPostionDesc(userPositionDTO.getUserPostionDesc());
        userPosition.setDateCreated(userPositionDTO.getDateCreated());
        userPosition.setDateUpdated(userPositionDTO.getDateUpdated());
        userPosition.setCreatedBy(userPositionDTO.getCreatedBy());
        userPosition.setModifiedBy(userPositionDTO.getModifiedBy());
        return userPosition;
    }
}

