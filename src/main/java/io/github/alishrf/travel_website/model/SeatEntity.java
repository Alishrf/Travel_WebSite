package io.github.alishrf.travel_website.model;


import javax.persistence.*;
import javax.ws.rs.DefaultValue;

@Entity
@Table(name = "seat")
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    @Column(name = "seat_number")
    private int seatNumber;

    @DefaultValue("false")
    @Column(name = "is_full")
    private boolean isFull;

    @DefaultValue("2")
    @Enumerated()
    private GenderEntity genderEntityPerson;

    public SeatEntity() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
