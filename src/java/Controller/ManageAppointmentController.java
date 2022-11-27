package Controller;

import entity.Appointment;
import entity.Employee;
import entity.Employeerecord;
import entity.Empschedule;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ManageAppointmentController {

    public static List<Appointment> getAppointments(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        TypedQuery<Appointment> app = entityManager.createNamedQuery("Appointment.getAppointments", Appointment.class);
        app.setParameter(1, id);


        entityManager.getTransaction().commit();
        List<Appointment> appointment = app.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return appointment;
    }



    public static void updateAppointment(int appId, int cnic, int docId, Date appDate, String appTime, String status, int amount) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("UPDATE Appointment SET patientCNIC = ?2, doctorID = ?3, appointmentDate = ?4, appointmentTime = ?5, status = ?6, feeAmount = ?7 where appointmentID = ?1");
        query.setParameter(1, appId);
        query.setParameter(2, cnic);
        query.setParameter(3, docId);
        query.setParameter(4, appDate);
        query.setParameter(5, appTime);
        query.setParameter(6, status);
        query.setParameter(7, amount);

        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void addAppointment(int appId, int cnic, int docId, Date appDate, String appTime, String status, int amount) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("INSERT INTO appointment (appointmentID, patientCNIC, doctorID, appointmentDate, appointmentTime, status, feeAmount) " +
                " VALUES(?,?,?,?,?,?,?)");
        query.setParameter(1, appId);
        query.setParameter(2, cnic);
        query.setParameter(3, docId);
        query.setParameter(4, appDate);
        query.setParameter(5, appTime);
        query.setParameter(6, status);
        query.setParameter(7, amount);

        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }


    public static List<Appointment> getAllAppointments(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        TypedQuery<Appointment> appointment = entityManager.createNamedQuery("Appointment.getAllAppointment", Appointment.class);

        entityManager.getTransaction().commit();
        List<Appointment> app = appointment.getResultList();

        for(Appointment a : appointment.getResultList())
            System.out.println(a);

        entityManager.close();
        entityManagerFactory.close();
        return app;
    }


    public static Appointment getAppointment(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        TypedQuery<Appointment> app = entityManager.createNamedQuery("Appointment.getAppointment", Appointment.class);
        app.setParameter(1, id);


        entityManager.getTransaction().commit();
        Appointment a = app.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();
        return a;
    }

    public static int getLastAppointment() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Query lastId = entityManager.createNativeQuery("Select Max(appointmentID) from appointment");
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
//        addAppointment(3232232, 2, "2022-11-17", "12:00:00", "pending");
    }
}
