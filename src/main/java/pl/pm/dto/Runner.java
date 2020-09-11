package pl.pm.dto;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Runner implements Comparable<Runner>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "best_time")
    private LocalTime bestTime;

    @Column(name = "current_run_time")
    private LocalTime currentRunTime;

    @ManyToMany(mappedBy = "participants")
    private List<Run> runs;

    public Runner(String firstName, String lastName, LocalTime bestTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestTime = bestTime;
    }

    public Runner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Runner(){
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalTime getBestTime() {
        return bestTime;
    }

    public String getBestTimeAsString() {
        return bestTime != null ? bestTime.toString() : "";
    }

    public void setBestTime(LocalTime bestTime) {
        this.bestTime = bestTime;
    }

    public LocalTime getCurrentRunTime() {
        return currentRunTime;
    }

    public String getCurrentRunTimeAsString() {
        return currentRunTime != null ? currentRunTime.toString() : "";
    }

    public void setCurrentRunTime(LocalTime currentRunTime) {
        this.currentRunTime = currentRunTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Runner)) return false;
        Runner runner = (Runner) o;
        return id.equals(runner.id) &&
                firstName.equals(runner.firstName) &&
                lastName.equals(runner.lastName) &&
                bestTime.equals(runner.bestTime) &&
                Objects.equals(currentRunTime, runner.currentRunTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, bestTime, currentRunTime);
    }

    @Override
    public int compareTo(Runner runner) {
       return this.currentRunTime.compareTo(runner.currentRunTime);
    }
}
