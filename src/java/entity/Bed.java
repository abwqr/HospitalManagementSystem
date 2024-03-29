package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Bed {
    private int bedId;
    private Date startDate;
    private Date endDate;
    private String status;
    private Integer feeAmount;

    @Id
    @Column(name = "bedId")
    public int getBedId() {
        return bedId;
    }

    public void setBedId(int bedId) {
        this.bedId = bedId;
    }

    @Basic
    @Column(name = "startDate")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "endDate")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "feeAmount")
    public Integer getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Integer feeAmount) {
        this.feeAmount = feeAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bed bed = (Bed) o;

        if (bedId != bed.bedId) return false;
        if (startDate != null ? !startDate.equals(bed.startDate) : bed.startDate != null) return false;
        if (endDate != null ? !endDate.equals(bed.endDate) : bed.endDate != null) return false;
        if (status != null ? !status.equals(bed.status) : bed.status != null) return false;
        if (feeAmount != null ? !feeAmount.equals(bed.feeAmount) : bed.feeAmount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bedId;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (feeAmount != null ? feeAmount.hashCode() : 0);
        return result;
    }
}
