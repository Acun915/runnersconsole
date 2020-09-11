package pl.pm.dao;

import pl.pm.dto.Runner;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class RunnerDao {

    //workat home
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

    public List<Runner> getRunnersFromSpecificRun(Integer runId) {
        List<Runner> runners = new ArrayList<>();
        List<Integer> runnersId = entityManager.createNativeQuery(
                "SELECT participants_id FROM run_runner WHERE runs_id =" + runId)
                .getResultList();

        for (int integer : runnersId) {
            runners.add(findRunnerById(integer));
        }

         return runners;
    }

    private Runner findRunnerById(Integer id) {
        return entityManager.find(Runner.class, id);

    }

}
