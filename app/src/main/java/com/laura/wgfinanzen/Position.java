package com.laura.wgfinanzen;

import java.util.Date;

/**
 * Created by Laura on 14.09.2015.
 */
public class Position {
    private String name, description;
    private Date date;
    private double value;
    private Person buyer;

    public Position(){}
    
    public Position(String name, String description, Person buyer, Date date, double value) {
        this.name = name;
        this.description = description;
        this.buyer = buyer;
        this.date = date;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Person getBuyer() {
        return buyer;
    }

    public void setBuyer(Person buyer) {
        this.buyer = buyer;
    }
}
