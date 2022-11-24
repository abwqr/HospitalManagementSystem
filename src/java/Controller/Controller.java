package Controller;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Controller {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
    }
}
/*
* get all doctors: select * from employee where type not like "admin" and type not like "receptionist"
* get all receptionists: select * from employee where type like "receptionist"
* get all admin: select * from employee where type like "admin"
* get employee from employee record: select * from employeerecord inner join employee on employee.empid=employeerecord.empid;
* get available beds:  select * from bed where status like "available"
* get all doctor schedule: select * from empschedule where empid in (select empid from employee where type not like "admin" and type not like "receptionist")
*  */

/* * update
* update beds: UPDATE bed SET patientCNIC = 76875789 WHERE bedid = 1;
* update employee record: UPDATE employeerecord SET phonenumber = 03321124 WHERE empid = 1;
* update employee schedule: UPDATE empschedule SET room = "C604" WHERE empid = 2;
* update employee: UPDATE employee SET password = "10000" WHERE empid = 2;
* update appoinmtent: UPDATE appointment SET status = "completed" WHERE patientcnic = 12345567;
 * */

/* * delete
* DELETE FROM employee WHERE empid=1;
 * */

/*
* * View queries
* Admin:
*   employees:
*       manage doctors
*       manage receptionist
*   records:
*       manage doctors
*       manage receptionist
*   schedule:
*       manage doctors
* Doctor:
*   Appointment:
*       view by date range
*   Schedule:
*       view entire schedule
* Receptionist:
*   Appointment:
*       get all doctor schedule
*       get doctor schedule by id
*   Beds:
*       get available beds
*/