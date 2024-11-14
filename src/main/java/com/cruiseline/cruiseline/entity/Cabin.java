package com.cruiseline.cruiseline.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cabins")
public class Cabin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cruise_liner_id")
    private CruiseLiner cruiseLiner;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private CabinClass cabinClass;

    @Column(name = "deck_number")
    private Long deckNumber;

    @Column(name = "capacity")
    private Long capacity;

    @Column(name = "adult_daily_cost")
    private BigDecimal adultDailyCost;

    @Column(name = "child_daily_cost")
    private BigDecimal childDailyCost;

    @Column(name = "amount_on_cruise_liner")
    private Long amountOnCruiseLiner;
}
