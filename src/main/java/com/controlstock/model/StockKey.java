package com.controlstock.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StockKey implements Serializable {

    @Column(name = "Id", nullable = false)
    private int id;

    @Column(name = "Version", nullable = false)
    private int version;

    /** getters and setters **/
}
