package com.mariia.entities;

import javax.persistence.*;

@Entity
public class HomeAddress {
    @Id
    @GeneratedValue
    int id;
    String street;
    @ManyToOne
    Person person;

    public HomeAddress() {
    }

    public HomeAddress(String street) {
        this.street = street;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

//    public String getStreet() {
//        return street;
//    }
}
