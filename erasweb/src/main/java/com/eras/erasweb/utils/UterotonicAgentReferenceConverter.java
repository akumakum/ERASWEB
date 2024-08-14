package com.eras.erasweb.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.eras.erasweb.dto.UterotonicAgentReferenceDTO;
import com.eras.erasweb.model.UterotonicAgentReference;

public class UterotonicAgentReferenceConverter {

    public static UterotonicAgentReferenceDTO entityToDto(UterotonicAgentReference entity) {
        UterotonicAgentReferenceDTO dto = new UterotonicAgentReferenceDTO();
        dto.setUterotonicAgentRefId(entity.getUterotonicAgentRefId());
        dto.setUterotonicAgentDesc(entity.getUterotonicAgentDesc());
        dto.setDateCreated(entity.getDateCreated());
        dto.setDateUpdated(entity.getDateUpdated());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedBy(entity.getModifiedBy());
        return dto;
    }

    public static UterotonicAgentReference dtoToEntity(UterotonicAgentReferenceDTO dto) {
        UterotonicAgentReference entity = new UterotonicAgentReference();
        entity.setUterotonicAgentRefId(dto.getUterotonicAgentRefId());
        entity.setUterotonicAgentDesc(dto.getUterotonicAgentDesc());
        entity.setDateCreated(dto.getDateCreated());
        entity.setDateUpdated(dto.getDateUpdated());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setModifiedBy(dto.getModifiedBy());
        return entity;
    }

    public static List<UterotonicAgentReferenceDTO> entitiesToDtos(List<UterotonicAgentReference> entities) {
        return entities.stream()
                       .map(UterotonicAgentReferenceConverter::entityToDto)
                       .collect(Collectors.toList());
    }

    public static List<UterotonicAgentReference> dtosToEntities(List<UterotonicAgentReferenceDTO> dtos) {
        return dtos.stream()
                   .map(UterotonicAgentReferenceConverter::dtoToEntity)
                   .collect(Collectors.toList());
    }
}
