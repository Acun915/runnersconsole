package pl.pm.dto;


import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Run {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String event_name;

    @Column(name = "distance")
    private static final Integer DISTANCE_IN_KM = 10;

    @ManyToMany
    private List<Runner> participants;

    @Column(name = "best_time")
    private LocalTime bestTime;

    @Column(name = "best_runner")
    private String bestRunner;
}
