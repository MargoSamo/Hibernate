package com.mariia.entities;

import javax.persistence.*;
import java.util.List;

//@Entity
@Embeddable
public class HomeAddress {
//    @Id
//    @GeneratedValue
//    int id;
    String street;
//    @ManyToMany
//    List<Person> person;

    public HomeAddress() {
    }

    public HomeAddress(String street) {
        this.street = street;
    }

//    public void setPerson(List<Person> person) {
//        this.person = person;
//    }

//    public String getStreet() {
//        return street;
//    }
}
