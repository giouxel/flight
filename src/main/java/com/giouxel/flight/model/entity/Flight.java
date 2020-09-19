package com.giouxel.flight.model.entity;

import com.giouxel.flight.model.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Duration;
import java.time.OffsetDateTime;

@Entity
@Table(name = "flight")
//@Data
public class Flight extends BaseEntity {

    private OffsetDateTime departure;

    @ManyToOne(fetch = FetchType.LAZY)
    private Airport origin;

    @ManyToOne(fetch = FetchType.LAZY)
    private Airport destination;

    private Duration flightTime;

    public OffsetDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(OffsetDateTime departure) {
        this.departure = departure;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Duration getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Duration flightTime) {
        this.flightTime = flightTime;
    }
}
