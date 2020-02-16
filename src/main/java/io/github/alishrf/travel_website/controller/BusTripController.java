package io.github.alishrf.travel_website.controller;



import io.github.alishrf.travel_website.model.BusTripEntity;
import io.github.alishrf.travel_website.service.BusTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BusTripController {
    @Autowired
    BusTripService busTripService;

    @PostMapping("/bustrips")
    public BusTripEntity createBusTrip(@RequestBody @Valid BusTripEntity busTripEntity){
        return busTripService.createBusTripe(busTripEntity);
    }

    @GetMapping("/bustrips")
    public List<BusTripEntity> getAllBusTrips(){
        return busTripService.ShowAllBusTrip();
    }




}
