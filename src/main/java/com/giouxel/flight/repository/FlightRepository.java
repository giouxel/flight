package com.giouxel.flight.repository;

import com.giouxel.flight.model.entity.Flight;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("SELECT f FROM Flight f left join fetch f.origin r join fetch f.destination d" +
            " where r.code =:airport ")
    List<Flight> findAllByAirport(String airport);
}
