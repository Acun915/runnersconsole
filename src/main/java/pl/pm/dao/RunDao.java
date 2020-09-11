package pl.pm.dao;

import pl.pm.dto.Run;
import pl.pm.dto.Runner;

import javax.persistence.EntityManager;
import java.util.List;

public class RunDao {

    private EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();

    public boolean addRun(Run run){

        entityManager.getTransaction().begin();

        entityManager.persist(run);

        entityManager.getTransaction().commit();

        return true;
    }

    public boolean deleteRun(Integer id) {
        entityManager.getTransaction().begin();

        Run run = findRunById(id);
        if (run == null) {
            return false;
        }
        entityManager.remove(run);
        entityManager.getTransaction().commit();

        return true;
    }

    public List<Run> getAllRuns() {
        return (List<Run>) entityManager.createQuery("SELECT r from Run r").getResultList();
    }

    private Run findRunById(Integer id) {
        return entityManager.find(Run.class, id);
    }
}
