package io.github.alishrf.travel_website.controller;

import io.github.alishrf.travel_website.dto.TicketRequest;
import io.github.alishrf.travel_website.model.TicketEntity;
import io.github.alishrf.travel_website.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/tickets")
    public TicketEntity createTicket(@RequestBody @Valid TicketRequest ticketRequest){
        return ticketService.saveTicket(ticketRequest);
    }


}
