package databaseintegration;

import databaseintegration.model.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Henrique
 */
public class Application {

    public static void main(String[] args) {
        /*StudentDAO dao = new StudentDAO();
        dao.readAll().forEach(student -> {
            System.out.println(student.getName());
        });*/
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DatabaseIntegrationPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Student.findAll", Student.class);
        List<Student> list = query.getResultList();
        list.forEach(student -> {
            System.out.println(student.getName());
        });
    }
}
