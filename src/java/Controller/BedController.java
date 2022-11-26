package Controller;

import entity.Bed;
import entity.Employeerecord;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class BedController {
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
}
