package com.giouxel.flight.controller;

import com.giouxel.flight.config.Constant;
import com.giouxel.flight.model.dto.FlightDTO;
import com.giouxel.flight.service.FlightService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = Constant.BASE_REST_URL)
public class FlightController extends Constant {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping(value = FLIGHT_URL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getFlightList(@RequestParam(value = "airport", defaultValue = "") String airport) {
        List<FlightDTO> listFlight = flightService.getFlightList(airport);
        if (!CollectionUtils.isEmpty(listFlight)) {
            return ResponseEntity.ok().body(listFlight);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
