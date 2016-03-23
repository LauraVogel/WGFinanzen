package com.laura.wgfinanzen;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Laura on 24.09.2015.
 */
public class Person {
    public static  Map<String, Person> residents = new HashMap<>();
    public static Person login = new Person();
    private Map<String, Double> schulden;
    private String name;

    public Person(){}

    public Person(String name){
        this.name = name;
        schulden = new HashMap<>();
        residents.put(name, this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doPayOff(double wert, Person empfaenger){
        double altschuld = schulden.get(empfaenger.getName());
        schulden.put(empfaenger.getName(),altschuld-wert);
        //SPEICHERN
    }


}


