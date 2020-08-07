package io.github.alishrf.travel_website.service;


import io.github.alishrf.travel_website.dto.TicketRequest;
import io.github.alishrf.travel_website.model.PassengerEntity;
import io.github.alishrf.travel_website.model.SeatEntity;
import io.github.alishrf.travel_website.model.TicketEntity;
import io.github.alishrf.travel_website.repository.SeatRepository;
import io.github.alishrf.travel_website.repository.TicketRepository;
import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Logger;


@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    SeatRepository seatRepository;

    Logger logger = Logger.getLogger("Ticket Service");


    public TicketEntity generateTicketCode(TicketEntity ticket){
        Hashids hashids = new Hashids(ticket.getSeat().getBusTrip().toString());
        ticket.setTicketCode(hashids.encode(ticket.getPassenger().getID(),
                ticket.getID(),ticket.getSeat().getID(),
                Timestamp.valueOf(LocalDateTime.now()).getTime()));
        return ticket;
    }

    public TicketEntity saveTicket(TicketRequest ticketRequest){
        SeatEntity seat  = seatRepository.findByBusTripIDAndSeatNumber(
                ticketRequest.getBusTripID(),ticketRequest.getSeatNumber());
        if(seat.isFull()){
            logger.warning("Your Selected Seat Is Full");
            return null;
        }
        PassengerEntity passenger = ticketRequest.getPassenger();
        seat.setFull(true);
        seat.setGenderEntityPerson(passenger.getGender());
        TicketEntity ticket = new TicketEntity();
        ticket.setPassenger(passenger);
        ticket.setSeat(seat);
        passenger.addToActivityTicket(ticket);
        ticket = ticketRepository.save(ticket);
        ticket = generateTicketCode(ticket);
        return ticketRepository.save(ticket);
    }




}
