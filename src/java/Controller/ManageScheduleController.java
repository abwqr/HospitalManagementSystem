package Controller;

import entity.Employee;
import entity.Employeerecord;
import entity.Empschedule;

import javax.persistence.*;
import java.util.List;

public class ManageScheduleController {
    public static List<Employee> getAllDoctors(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        TypedQuery<Employee> employee = entityManager.createNamedQuery("Employee.getAllDoctors", Employee.class);

        employee.setParameter(1, "admin");
        employee.setParameter(2, "receptionist");


        entityManager.getTransaction().commit();
        List<Employee> emp = employee.getResultList();

        for(Employee e : employee.getResultList())
            System.out.println(e);

        entityManager.close();
        entityManagerFactory.close();
        return emp;
    }

    public static void addSchedule(int id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("INSERT INTO empschedule (empID) " +
                " VALUES(?)");
        query.setParameter(1, id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }


    public static List<Empschedule> getAllSchedules(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        TypedQuery<Empschedule> empRec = entityManager.createNamedQuery("Empschedule.getAll", Empschedule.class);


        entityManager.getTransaction().commit();
        List<Empschedule> emp = empRec.getResultList();


        entityManager.close();
        entityManagerFactory.close();
        return emp;
    }


    public static void clearSchedule(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("UPDATE Empschedule SET shiftDate = ?1, room = ?2, startTime = ?3, endTime = ?4 where empID = ?5");
        query.setParameter(1, null);
        query.setParameter(2, null);
        query.setParameter(3, null);
        query.setParameter(4, null);
        query.setParameter(5, id);

        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void main(String[] args) {
//        getAllDoctors();
        addSchedule(2);
    }

}
