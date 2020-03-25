package io.github.alishrf.travel_website.repository;


import io.github.alishrf.travel_website.model.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository  extends JpaRepository<SeatEntity,Long> {
    SeatEntity findByBusTripIDAndSeatNumber(Long busID,int seatNum);
}
