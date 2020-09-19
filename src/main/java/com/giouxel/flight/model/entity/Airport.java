package com.giouxel.flight.model.entity;

import com.giouxel.flight.model.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "airport")
//@Data
public class Airport extends BaseEntity {

    private String name;

    private String code;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}
