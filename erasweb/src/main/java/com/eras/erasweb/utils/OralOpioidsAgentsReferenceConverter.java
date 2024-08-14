package com.eras.erasweb.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.eras.erasweb.dto.OralOpioidsAgentsReferenceDTO;
import com.eras.erasweb.model.OralOpioidsAgentsReference;

public class OralOpioidsAgentsReferenceConverter {

    public static OralOpioidsAgentsReferenceDTO toDto(OralOpioidsAgentsReference entity) {
        if (entity == null) {
            return null;
        }

        return OralOpioidsAgentsReferenceDTO.builder()
                .oralOpioidsAgentsRefId(entity.getOralOpioidsAgentsRefId())
                .oralOpioidsAgentsRefDesc(entity.getOralOpioidsAgentsRefDesc())
                .dateCreated(entity.getDateCreated())
                .dateUpdated(entity.getDateUpdated())
                .createdBy(entity.getCreatedBy())
                .modifiedBy(entity.getModifiedBy())
                .build();
    }

    public static OralOpioidsAgentsReference toEntity(OralOpioidsAgentsReferenceDTO dto) {
        if (dto == null) {
            return null;
        }

        OralOpioidsAgentsReference entity = new OralOpioidsAgentsReference();
        entity.setOralOpioidsAgentsRefId(dto.getOralOpioidsAgentsRefId());
        entity.setOralOpioidsAgentsRefDesc(dto.getOralOpioidsAgentsRefDesc());
        entity.setDateCreated(dto.getDateCreated());
        entity.setDateUpdated(dto.getDateUpdated());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setModifiedBy(dto.getModifiedBy());
        
        return entity;
    }

    public static List<OralOpioidsAgentsReferenceDTO> toDtoList(List<OralOpioidsAgentsReference> entities) {
        return entities.stream()
                .map(OralOpioidsAgentsReferenceConverter::toDto)
                .collect(Collectors.toList());
    }

    public static List<OralOpioidsAgentsReference> toEntityList(List<OralOpioidsAgentsReferenceDTO> dtos) {
        return dtos.stream()
                .map(OralOpioidsAgentsReferenceConverter::toEntity)
                .collect(Collectors.toList());
    }
}
