package pl.pm.dto;


import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Run {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "distance")
    private static final Integer DISTANCE_IN_KM = 10;

    @ManyToMany
    private List<Runner> participants;

    @Column(name = "best_time")
    private LocalTime bestTime;

    @Column(name = "best_runner")
    private String bestRunner;


    public Run(String eventName) {
        this.eventName = eventName;
        this.participants = new ArrayList<>();
    }

    public Run() {
    }

    public Integer getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public static Integer getDistanceInKm() {
        return DISTANCE_IN_KM;
    }

    public List<Runner> getParticipants() {
        return participants;
    }

    public LocalTime getBestTime() {
        return bestTime;
    }

    public String getBestRunner() {
        return bestRunner;
    }
}
