package io.github.alishrf.travel_website.exception;


import io.github.alishrf.travel_website.model.Trip;

import javax.persistence.*;

@Entity
@Table(name = "bus_trip")
public class BusTrip extends Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    //add seat class....



}
