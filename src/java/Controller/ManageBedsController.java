package Controller;

import entity.Bed;
import entity.Employeerecord;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ManageBedsController {
    public static List<Bed> getBeds(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        TypedQuery<Bed> bed = entityManager.createNamedQuery("Bed.getAll", Bed.class);


        entityManager.getTransaction().commit();
        List<Bed> b = bed.getResultList();


        entityManager.close();
        entityManagerFactory.close();
        return b;
    }
    public static int getLastBedID() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Query lastId = entityManager.createNativeQuery("Select Max(bedId) from bed");
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

    public static void deleteBed(int id){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("DELETE FROM Bed WHERE bedId = ?");
        query.setParameter(1, id);

        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static Bed getBed(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        TypedQuery<Bed> bed = entityManager.createNamedQuery("Bed.getBed", Bed.class);
        bed.setParameter(1, id);


        entityManager.getTransaction().commit();
        Bed b = bed.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();
        return b;
    }


    public static void updateBed(Bed bed) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("UPDATE Bed SET patientCNIC = ?1, startDate = ?2, endDate = ?3, status = ?4, feeAmount = ?5 where bedId = ?6" );
        query.setParameter(1, bed.getPatientCnic());
        query.setParameter(2, bed.getStartDate());
        query.setParameter(3, bed.getEndDate());
        query.setParameter(4, bed.getStatus());
        query.setParameter(5, bed.getFeeAmount());
        query.setParameter(6, bed.getBedId());

        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }


    public static void addBed(int id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("INSERT INTO bed (bedId, patientCNIC, startDate, endDate, status, feeAmount) " +
                " VALUES(?,?,?,?,?,?)");
        query.setParameter(1, id);
        query.setParameter(2, null);
        query.setParameter(3, null);
        query.setParameter(4, null);
        query.setParameter(5, "available");
        query.setParameter(6, null);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
