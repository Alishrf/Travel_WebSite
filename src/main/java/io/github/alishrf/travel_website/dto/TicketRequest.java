package io.github.alishrf.travel_website.dto;

import io.github.alishrf.travel_website.model.GenderEntity;
import io.github.alishrf.travel_website.model.PassengerEntity;
import io.github.alishrf.travel_website.model.TicketEntity;

public class TicketRequest {

    private String couponCode;
    private Long busTripID;
    private int seatNumber;
    private GenderEntity gender;
    private PassengerEntity passenger;

    public TicketRequest() {
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Long getBusTripID() {
        return busTripID;
    }

    public void setBusTripID(Long busTripID) {
        this.busTripID = busTripID;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public GenderEntity getGender() {
        return gender;
    }

    public void setGender(GenderEntity gender) {
        this.gender = gender;
    }

    public PassengerEntity getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerEntity passenger) {
        this.passenger = passenger;
    }
}
