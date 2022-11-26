package entity;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NamedQuery(name = "EmployeeRecord.getAll", query = "Select e from Employeerecord e")
@NamedQuery(name = "EmployeeRecord.getEmpRec", query = "Select e from Employeerecord e where empId = ?1")


public class Employeerecord {
    private int empId;
    private Date hireDate;
    private double salary;
    private String phoneNumber;
    private Employee employeeByEmpId;

    @Id
    @Column(name = "empID")
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "hireDate")
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Basic
    @Column(name = "salary")
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employeerecord that = (Employeerecord) o;

        if (empId != that.empId) return false;
        if (Double.compare(that.salary, salary) != 0) return false;
        if (hireDate != null ? !hireDate.equals(that.hireDate) : that.hireDate != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = empId;
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "empID", referencedColumnName = "empID", nullable = false)
    public Employee getEmployeeByEmpId() {
        return employeeByEmpId;
    }

    public void setEmployeeByEmpId(Employee employeeByEmpId) {
        this.employeeByEmpId = employeeByEmpId;
    }

    @Override
    public String toString() {
        return "Employeerecord{" +
                "empId=" + empId +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", employeeByEmpId=" + employeeByEmpId +
                '}';
    }
}
