package io.github.alishrf.travel_website.controller;



import io.github.alishrf.travel_website.model.BusTrip;
import io.github.alishrf.travel_website.repository.BusTripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class BusTripController {
    @Autowired
    BusTripRepository busTripRepository;


    @PostMapping("/bustrips")
    public BusTrip createBusTrip(@RequestBody @Valid BusTrip busTrip){
        //..
        return null;
    }


}
