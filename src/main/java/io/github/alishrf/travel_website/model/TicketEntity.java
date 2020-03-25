package io.github.alishrf.travel_website.model;


import javax.persistence.*;

@Entity
@Table
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long ID;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = PassengerEntity.class,
            cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "fk_passenger" ,referencedColumnName = "id")
    private PassengerEntity passenger;

    @OneToOne(targetEntity = SeatEntity.class, cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "fk_seat",referencedColumnName = "id")
    private SeatEntity seat;

    @Column(unique = true,name = "ticket_code")
    private String ticketCode;

    @OneToOne(targetEntity = ImageEntity.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_qr")
    private ImageEntity imageEntity;


    public TicketEntity() {
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public PassengerEntity getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerEntity passenger) {
        this.passenger = passenger;
    }

    public SeatEntity getSeat() {
        return seat;
    }

    public void setSeat(SeatEntity seat) {
        this.seat = seat;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public ImageEntity getImageEntity() {
        return imageEntity;
    }

    public void setImageEntity(ImageEntity imageEntity) {
        this.imageEntity = imageEntity;
    }
}
