package com.eras.erasweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eras.erasweb.model.MrnSequence;
import com.eras.erasweb.model.MrnSequenceId;

@Repository
public interface MrnSequenceRepository extends JpaRepository<MrnSequence, MrnSequenceId> {

    @Query("SELECT COALESCE(MAX(ms.sequenceNumber), 0) FROM MrnSequence ms WHERE ms.mrnNo = :mrnNo")
    Integer findMaxSequenceNumberByMrnNo(@Param("mrnNo") String mrnNo);
    
    
}