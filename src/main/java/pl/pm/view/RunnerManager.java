package pl.pm.view;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import pl.pm.dao.RunnerDao;
import pl.pm.dto.Runner;
import pl.pm.view.table.TablePrinter;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

public class RunnerManager {

    private RunnerDao runnerDao = new RunnerDao();

    public Runner createRunner(String firstName, String lastName) {
        return new Runner(firstName, lastName);
    }

    public boolean deleteRunner(Integer id) {
       return runnerDao.deleteRunner(id);
    }

    public boolean updateFirstAndLastName(Integer id, String firstName, String lastName){
        return runnerDao.updateFirstAndLastName(id, firstName, lastName);
    }

    public void printList(List<Runner> runners) {
        TablePrinter<Runner> tablePrinter = new TablePrinter<Runner>()
                .withData(runners)
                .withColumn("First Name", runner -> ((Runner) runner).getFirstName())
                .withColumn("Last Name", runner -> ((Runner) runner).getLastName())
                .withColumn("Best Time", runner -> ((Runner) runner).getBestTimeAsString())
                .withColumn("Current Run Time", runner -> ((Runner) runner).getCurrentRunTimeAsString());

        tablePrinter.printTable();
    }
}
