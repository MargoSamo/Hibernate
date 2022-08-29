package com.mariia.entities.hierarchies;

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@MappedSuperclass
//@OptimisticLocking(type = OptimisticLockType.VERSION)
public class Car {
    @Id
    @GeneratedValue
    private int id;
    private String number;
//    @Version
//    int version;

    public Car() {
    }

    public Car(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
