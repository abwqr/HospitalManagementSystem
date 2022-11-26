package Controller;

import entity.Employee;

import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class ManageEmployeeController {


    public static void addEmployee(int id, String fname, String lname, String type, String password) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("INSERT INTO employee (empID, firstName,lastName, type, password) " +
                " VALUES(?,?,?,?,?)");
        query.setParameter(1, id);
        query.setParameter(2, fname);
        query.setParameter(3, lname);
        query.setParameter(4, type);
        query.setParameter(5, password);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }







    public static int getLastEmpID() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Query lastId = entityManager.createNativeQuery("Select Max(empID) from employee");
            System.out.println(lastId.getSingleResult());
            transaction.commit();

            return (int) lastId.getSingleResult();

        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }


    public static void main(String[] args) {
        addEmployee(9,"abc", "efg", "receptionist", "1234");
    }
}



