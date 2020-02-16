package io.github.alishrf.travel_website.service;

import io.github.alishrf.travel_website.model.BusTripEntity;
import io.github.alishrf.travel_website.repository.BusTripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;


@Service
public class BusTripService {
    private Logger logger =Logger.getLogger("My Bus Trip Service");
    @Autowired
    BusTripRepository busTripRepository;

    @Autowired
    CompanyService companyService;


    public BusTripEntity createBusTripe(BusTripEntity busTripEntity){
        if(busTripEntity.getOff()>100 || busTripEntity.getOff() <0){
            logger.warning("Bus Trip OFF Is Not In Range 0-100");
            return null;
        }
        if(busTripEntity.getStartDate().compareTo(Timestamp.valueOf(LocalDateTime.now()) ) < 0){
            logger.warning("Bus Trip Start Date Is Expired");
            return null;
        }

        return busTripRepository.save(busTripEntity);

    }

    public List<BusTripEntity> ShowAllBusTrip(){
        List<BusTripEntity> busTripEntities = busTripRepository.findAll();
        if(busTripEntities == null){
            logger.warning("There Is Problem For Showing All bus Trips | bus Trips Is Null");
            return null;
        }
        return busTripEntities;

    }
    /*public BusTrip FindBusTripByID(Long ID){
        BusTrip busTrip = busTripRepository.findById(ID).orElseThrow(() -> new ResourceNotFoundException());


    }*/

}
