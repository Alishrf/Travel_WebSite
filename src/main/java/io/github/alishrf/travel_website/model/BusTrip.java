package io.github.alishrf.travel_website.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bus_trip")
public class BusTrip extends Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    @Enumerated
    @Column(name = "bus_type")
    private BusType busType;

    @OneToMany(targetEntity = Seat.class)
    @JoinColumn(name = "seats",referencedColumnName = "id")
    private List<Seat> seats;









}
