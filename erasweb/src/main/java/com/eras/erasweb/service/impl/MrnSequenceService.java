package com.eras.erasweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eras.erasweb.model.MrnSequence;
import com.eras.erasweb.repository.MrnSequenceRepository;

@Service
public class MrnSequenceService {

	@Autowired
    private MrnSequenceRepository mrnSequenceRepository;

    @Transactional
    public Integer getCurrentMaxSequenceNumber(String mrnNo) {
        // Find the maximum sequence number for the given mrn_no
        return mrnSequenceRepository.findMaxSequenceNumberByMrnNo(mrnNo);
    }

    @Transactional
    public Integer getNextSequenceNumber(String mrnNo) {
        Integer maxSequenceNumber = getCurrentMaxSequenceNumber(mrnNo);
        Integer nextSequenceNumber = maxSequenceNumber + 1;

        // Save the new sequence
       // MrnSequence mrnSequence = new MrnSequence();
       // mrnSequence.setMrnNo(mrnNo);
       // mrnSequence.setSequenceNumber(nextSequenceNumber);
       // mrnSequenceRepository.save(mrnSequence);

        return nextSequenceNumber;
    }
    
    public boolean saveSequence(String mrn,Integer mrnSequenceNo)
    {
    	Integer maxSequenceNumber = getCurrentMaxSequenceNumber(mrn);
        Integer nextSequenceNumber = maxSequenceNumber + 1;
    	
        if(nextSequenceNumber==mrnSequenceNo) {
        // Save the new sequence
        MrnSequence mrnSequence = new MrnSequence();
        mrnSequence.setMrnNo(mrn);
        mrnSequence.setSequenceNumber(nextSequenceNumber);
        mrnSequenceRepository.save(mrnSequence);
        return true;
        }
        else
        {
        	 return false;
        }
       
    }
    
    
    
}
