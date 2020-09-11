package pl.pm;

import org.junit.Assert;
import org.junit.Test;
import pl.pm.dao.RunDao;
import pl.pm.dao.RunnerDao;
import pl.pm.dto.Run;
import pl.pm.dto.Runner;
import pl.pm.view.RunnerManager;

import java.time.LocalTime;
import java.util.List;


public class RunnerDaoTest {

    private RunnerDao runnerDao = new RunnerDao();
    private RunnerManager runnerManager = new RunnerManager();

    private RunDao runDao = new RunDao();

    @Test
    public void shouldAddRun() {
        Runner runner = runnerManager.createRunner("Jan", "Kowalski");
        runnerDao.addRunner(runner);
    }

    @Test
    public void shouldGetAllRunners() {
        List<Runner> runners = runnerDao.getAllRunners();

        runnerManager.printList(runners);
    }

    @Test
    public void shouldDeleteRunner() {
        Assert.assertTrue(runnerManager.deleteRunner(2));
    }

    @Test
    public void shouldUpdateFirstAndLastName() {
        Assert.assertTrue(runnerManager.updateFirstAndLastName(2, "Jon", "Snow"));
    }

    @Test
    public void shouldAddRunnerToRun() {
        Runner runner = runnerManager.createRunner("Jan", "Kowalski");
        runnerDao.addRunner(runner);

        Run run = new Run("THE GREATEST RUN");

        run.getParticipants().add(runner);

        runDao.addRun(run);

    }

    @Test
    public void shouldGetRunnersByRun() {
        List<Runner> runners =  runnerDao.getRunnersFromSpecificRun(2);
        System.out.println(runners.get(0).getFirstName());
    }
}
