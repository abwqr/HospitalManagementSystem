package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ManagePatientController {


    public static void addPatient(int id, String fname, String lname, String phNum) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("INSERT INTO patient (patientCNIC, patientFirstName, patientLastName, patientPhoneNumber) " +
                " VALUES(?,?,?,?)");
        query.setParameter(1, id);
        query.setParameter(2, fname);
        query.setParameter(3, lname);
        query.setParameter(4, phNum);

        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void main(String[] args) {

    }

}
