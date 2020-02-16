package io.github.alishrf.travel_website.repository;


import io.github.alishrf.travel_website.model.BusTripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusTripRepository extends JpaRepository<BusTripEntity,Long> {


}
