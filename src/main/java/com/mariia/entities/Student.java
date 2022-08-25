package com.mariia.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    int id;
    String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
