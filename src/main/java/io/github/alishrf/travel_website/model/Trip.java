package io.github.alishrf.travel_website.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;


public class Trip {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long ID;

    @Column(name = "source_city")
    @ManyToOne(targetEntity = City.class)
    private City sourceCity;

    @Column(name = "destination_city")
    @ManyToOne(targetEntity = City.class)
    private City destinationCity;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "price",length = 10)
    private int price;

    @Column(name = "residual_capacity")
    private int residualCapacity;

    @Size(min = 0,max = 100)
    private int off;

    @Column(name = "description")
    private String description;





}
