package Controller;

import entity.Employeerecord;
import javafx.event.ActionEvent;

import javax.persistence.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class ManageEmpRecordController {

    public static void addEmployeeRecord(int id, LocalDate hireDate, int salary, int phoneNum) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("INSERT INTO employeerecord (empID, hireDate, salary, phoneNumber) " +
                " VALUES(?,?,?,?)");
        query.setParameter(1, id);
        query.setParameter(2, hireDate);
        query.setParameter(3, salary);
        query.setParameter(4, phoneNum);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }


    public static void updateEmployeeRecord(int id, int salary, int phoneNum) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
//        "UPDATE employeerecord SET salary = ?1, phonenumber = ?2 WHERE empid = ?3;"
        Query query = entityManager.createNativeQuery("UPDATE employeerecord SET salary = ?1, phonenumber = ?2 where empID = ?3");
        query.setParameter(1, salary);
        query.setParameter(2, phoneNum);
        query.setParameter(3, id);

        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }




    public static List<Employeerecord> getAllEmpRec(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        TypedQuery<Employeerecord> empRec = entityManager.createNamedQuery("EmployeeRecord.getAll", Employeerecord.class);


        entityManager.getTransaction().commit();
        List<Employeerecord> emp = empRec.getResultList();


        entityManager.close();
        entityManagerFactory.close();
        return emp;
    }

    public static void deleteRec(int id){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("DELETE FROM employeerecord WHERE empID = ?");
        query.setParameter(1, id);

        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }


    public static Employeerecord getEmployeeRec(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        TypedQuery<Employeerecord> empRec = entityManager.createNamedQuery("EmployeeRecord.getEmpRec", Employeerecord.class);
        empRec.setParameter(1, id);


        entityManager.getTransaction().commit();
        Employeerecord emp = empRec.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();
        return emp;
    }

    public static void main(String[] args) {
//        getAllEmpRec();
//            deleteRec(1);
//        System.out.println(getEmployeeRec(1));
        updateEmployeeRecord(2, 1000, 11112);
    }


}
