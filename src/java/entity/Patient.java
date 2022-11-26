package entity;

import javax.persistence.*;

@Entity
public class Patient {
    private int patientCnic;
    private String patientPhoneNumber;
    private String patientFirstName;
    private String patientLastName;

    @Id
    @Column(name = "patientCNIC")
    public int getPatientCnic() {
        return patientCnic;
    }

    public void setPatientCnic(int patientCnic) {
        this.patientCnic = patientCnic;
    }

    @Basic
    @Column(name = "patientPhoneNumber")
    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    @Basic
    @Column(name = "patientFirstName")
    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    @Basic
    @Column(name = "patientLastName")
    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (patientCnic != patient.patientCnic) return false;
        if (patientPhoneNumber != null ? !patientPhoneNumber.equals(patient.patientPhoneNumber) : patient.patientPhoneNumber != null)
            return false;
        if (patientFirstName != null ? !patientFirstName.equals(patient.patientFirstName) : patient.patientFirstName != null)
            return false;
        if (patientLastName != null ? !patientLastName.equals(patient.patientLastName) : patient.patientLastName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = patientCnic;
        result = 31 * result + (patientPhoneNumber != null ? patientPhoneNumber.hashCode() : 0);
        result = 31 * result + (patientFirstName != null ? patientFirstName.hashCode() : 0);
        result = 31 * result + (patientLastName != null ? patientLastName.hashCode() : 0);
        return result;
    }



}
