package com.mariia.entities;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
//    @OneToOne(fetch = FetchType.LAZY)
//    @LazyToOne(LazyToOneOption.NO_PROXY)
    //@JoinColumn(name = "homeId")
    @OneToMany(mappedBy = "person")
    private List<HomeAddress> homeAddress;

    public Person() {
    }

    public Person(String name, List<HomeAddress> homeAddress) {
        this.name = name;
        this.homeAddress = homeAddress;
    }
}
