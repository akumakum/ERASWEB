package com.eras.erasweb.service;



import com.eras.erasweb.dto.ComorbiditiesReferenceDTO;

import java.util.List;

public interface ComorbiditiesReferenceServiceMaint {
    List<ComorbiditiesReferenceDTO> getAllReferences();
    ComorbiditiesReferenceDTO getReferenceById(long id);
    ComorbiditiesReferenceDTO createOrUpdateReference(ComorbiditiesReferenceDTO dto);
    public ComorbiditiesReferenceDTO updateReference(ComorbiditiesReferenceDTO dto);
    void deleteReference(long id);
}
