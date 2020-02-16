package io.github.alishrf.travel_website.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "bus_trip")
public class BusTripEntity extends TripEntity {
    @NotNull
    @Enumerated
    @Column(name = "bus_type")
    private BusTypeEntity busTypeEntity;

    @OneToMany(targetEntity = SeatEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_bus_id",referencedColumnName = "id")
    private List<SeatEntity> seatEntities;

    public BusTripEntity() {

    }

    public BusTypeEntity getBusTypeEntity() {
        return busTypeEntity;
    }

    public void setBusTypeEntity(BusTypeEntity busTypeEntity) {
        this.busTypeEntity = busTypeEntity;
    }

    public List<SeatEntity> getSeatEntities() {
        return seatEntities;
    }

    public void setSeatEntities(List<SeatEntity> seatEntities) {
        this.seatEntities = seatEntities;
    }
}
