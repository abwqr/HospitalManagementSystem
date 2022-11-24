//package Controller;
//import entity.Students;
//
//import javax.persistence.*;
//import java.util.List;
//
//public class LoginController {
//    public static List<Students> checkLogin(int id, String username) {
//
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//        try {
//            transaction.begin();
//
//            TypedQuery<Students> students = entityManager.createNamedQuery("Login.Students", Students.class);
//            students.setParameter(1, id);
//            students.setParameter(2, username);
//            transaction.commit();
//            int x = 0;
//            for(Students students1 : students.getResultList()){
//                System.out.println(students1);
//                x++;
//            }
//            if(x > 0) {
//                System.out.println(true);
////                return true;
//            }
//
//            return students.getResultList();
//        } finally {
//            if(transaction.isActive()) {
//                transaction.rollback();
//            }
//            entityManager.close();
//            entityManagerFactory.close();
//        }
////        return false;
//    }
//    public static void main(String[] args) {
//        System.out.println(checkLogin(1, "user1"));
//    }
//}
