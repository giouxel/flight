package com.giouxel.flight.model.base;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    private long id;
}
