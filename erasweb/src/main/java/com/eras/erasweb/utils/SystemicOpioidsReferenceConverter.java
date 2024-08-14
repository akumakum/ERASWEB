package com.eras.erasweb.utils;


import com.eras.erasweb.dto.SystemicOpioidsReferenceDTO;
import com.eras.erasweb.model.SystemicOpioidsReference;

import java.util.List;
import java.util.stream.Collectors;

public class SystemicOpioidsReferenceConverter {

    public static SystemicOpioidsReferenceDTO entityToDto(SystemicOpioidsReference entity) {
        return SystemicOpioidsReferenceDTO.builder()
                .systemicOpioidsRefId(entity.getSystemicOpioidsRefId())
                .systemicOpioidsDesc(entity.getSystemicOpioidsDesc())
                .dateCreated(entity.getDateCreated())
                .dateUpdated(entity.getDateUpdated())
                .createdBy(entity.getCreatedBy())
                .modifiedBy(entity.getModifiedBy())
                .build();
    }

    public static SystemicOpioidsReference dtoToEntity(SystemicOpioidsReferenceDTO dto) {
        return SystemicOpioidsReference.builder()
                .systemicOpioidsRefId(dto.getSystemicOpioidsRefId())
                .systemicOpioidsDesc(dto.getSystemicOpioidsDesc())
                .dateCreated(dto.getDateCreated())
                .dateUpdated(dto.getDateUpdated())
                .createdBy(dto.getCreatedBy())
                .modifiedBy(dto.getModifiedBy())
                .build();
    }

    public static List<SystemicOpioidsReferenceDTO> entityListToDtoList(List<SystemicOpioidsReference> entities) {
        return entities.stream()
                .map(SystemicOpioidsReferenceConverter::entityToDto)
                .collect(Collectors.toList());
    }

    public static List<SystemicOpioidsReference> dtoListToEntityList(List<SystemicOpioidsReferenceDTO> dtos) {
        return dtos.stream()
                .map(SystemicOpioidsReferenceConverter::dtoToEntity)
                .collect(Collectors.toList());
    }
}
