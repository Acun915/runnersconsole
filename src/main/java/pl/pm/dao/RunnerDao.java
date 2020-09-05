package pl.pm.dao;

import pl.pm.dto.Runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import java.util.List;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class RunnerDao {

    private EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();

    public boolean addRunner(Runner runner){

       entityManager.getTransaction().begin();

       entityManager.persist(runner);

       entityManager.getTransaction().commit();

       return true;
    }

    public boolean deleteRunner(Integer id) {
        entityManager.getTransaction().begin();

        Runner runner = findRunnerById(id);
        if (runner == null) {
            return false;
        }
        entityManager.remove(runner);
        entityManager.getTransaction().commit();

        return true;
    }

    public boolean updateFirstAndLastName(Integer id, String firstName, String lastName) {
        entityManager.getTransaction().begin();

        Runner runner = findRunnerById(id);
        if (runner == null) {
            return false;
        }

        runner.setFirstName(firstName);
        runner.setLastName(lastName);
        entityManager.getTransaction().commit();
        return true;
    }


    public List<Runner> getAllRunners() {
        return (List<Runner>) entityManager.createQuery("SELECT r from Runner r").getResultList();
    }

    private Runner findRunnerById(Integer id) {
        return entityManager.find(Runner.class, id);

    }

}
