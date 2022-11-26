package Controller;
import entity.Employee;

import javax.persistence.*;
import java.util.List;

public class LoginController {
    public static Employee checkLogin(int id, String password) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            TypedQuery<Employee> empLogin = entityManager.createNamedQuery("Employee.login", Employee.class);
            empLogin.setParameter(1, id);
            empLogin.setParameter(2, password);

            Employee emp = empLogin.getSingleResult();
//            for(Employee emp: empLogin.getResultList()){
//                System.out.println(emp.getType());
//                return emp;

//            }
            transaction.commit();
            return emp;


        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
//            return null;

        }

    }
    public static void main(String[] args) {
        System.out.println(checkLogin(1, "1234"));
    }
}
