package com.cruiseline.cruiseline.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cruise_liners")
public class CruiseLiner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_year")
    private String creationYear;

    @Column(name = "length")
    private BigDecimal length;

    @Column(name = "width")
    private BigDecimal width;

    @Column(name = "cruising_speed")
    private BigDecimal cruisingSpeed;

    @Column(name = "staff_amount")
    private Long staffAmount;

    @Column(name = "passengers_amount")
    private Long passengersAmount;

    @Column(name = "decks_amount")
    private Long decksAmount;

    @Column(name = "cabins_amount")
    private Long cabinsAmount;

    @OneToMany(mappedBy = "cruiseLiner", orphanRemoval = true)
    @ToString.Exclude
    private List<Cabin> cabins = new ArrayList<>();

    @OneToMany(mappedBy = "cruiseLiner")
    @ToString.Exclude
    private List<Cruise> cruises = new ArrayList<>();
}
