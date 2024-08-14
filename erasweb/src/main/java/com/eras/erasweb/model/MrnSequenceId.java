package com.eras.erasweb.model;
import java.io.Serializable;
import java.util.Objects;

public class MrnSequenceId implements Serializable {

    private String mrnNo;
    private Integer sequenceNumber;

    // Default constructor, equals, and hashCode methods
    public MrnSequenceId() {}

    public MrnSequenceId(String mrnNo, Integer sequenceNumber) {
        this.mrnNo = mrnNo;
        this.sequenceNumber = sequenceNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MrnSequenceId that = (MrnSequenceId) o;
        return Objects.equals(mrnNo, that.mrnNo) && Objects.equals(sequenceNumber, that.sequenceNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mrnNo, sequenceNumber);
    }
}
