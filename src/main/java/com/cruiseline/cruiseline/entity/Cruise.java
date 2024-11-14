package com.cruiseline.cruiseline.entity;

import com.cruiseline.cruiseline.anotation.CorrectDateTimeOrder;
import com.cruiseline.cruiseline.anotation.NotEmptyArrivalOrDepartureDateTime;
import com.cruiseline.cruiseline.anotation.SameArrivalAndDepartureCities;
import com.cruiseline.cruiseline.anotation.SufficientTimeBetweenDestinations;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cruises")
public class Cruise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "departure_date_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime departureDateTime;

    @Column(name = "arrival_date_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime arrivalDateTime;

    @SufficientTimeBetweenDestinations
    @NotEmptyArrivalOrDepartureDateTime
    @CorrectDateTimeOrder
    @SameArrivalAndDepartureCities
    @OneToMany(mappedBy = "cruise", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Destination> destinations = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "cruise_liner_id")
    private CruiseLiner cruiseLiner;

    @ManyToMany(mappedBy = "cruises")
    @ToString.Exclude
    private List<User> users = new ArrayList<>();
}
