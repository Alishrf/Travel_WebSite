package io.github.alishrf.travel_website.model;

import javax.persistence.*;

@Entity
@Table(name = "bus_type")
public enum BusTypeEntity {
    VIP25,SCANIA;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;


}
