package com.giouxel.flight.service;

import com.giouxel.flight.model.dto.FlightDTO;
import com.giouxel.flight.model.entity.Flight;
import com.giouxel.flight.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {
    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightDTO> getFlightList(String airport) {

        List<FlightDTO> listFlightDto = new ArrayList<>();

        List<Flight> listFlight = new ArrayList<Flight>();
        if (airport.length() > 0) {
        	listFlight = flightRepository.findAllByAirport(airport);
        }else {
        	listFlight = flightRepository.findAll();
        }

        for (Flight element: listFlight) {
            FlightDTO tempFlightDto = new FlightDTO();
            tempFlightDto.setAircraft(element.getOrigin().getAircraft().getModel());
            tempFlightDto.setDeparture(element.getDeparture());
            tempFlightDto.setOrigin(element.getOrigin().getCode());
            tempFlightDto.setDestination(element.getDestination().getCode());
            tempFlightDto.setArrival(element.getDeparture().plusMinutes(element.getFlightTime().toMinutes()));
            listFlightDto.add(tempFlightDto);
        }

        return listFlightDto;
    }
}
