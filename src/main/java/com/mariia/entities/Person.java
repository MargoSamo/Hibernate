package com.mariia.entities;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.SortComparator;

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
//    @JoinColumn(name = "homeId")
//    @OneToMany(mappedBy = "person")
//    @ManyToMany()
//    @JoinTable(
//            joinColumns = @JoinColumn(name = "personId"),
//            inverseJoinColumns = @JoinColumn(name = "homeID")
//    )
    @ElementCollection
    private List<HomeAddress> homeAddress;
    @ElementCollection
//    @OrderBy("marks")
//    @OrderColumn
//    @org.hibernate.annotations.OrderBy(clause = "marks DESC")
//    @SortComparator(MyComparator.class)
    private List<Integer> marks;

    @NaturalId
    private String iCode;

    public Person() {
    }

    public Person(String name, List<HomeAddress> homeAddress) {
        this.name = name;
        this.homeAddress = homeAddress;
    }

    public Person(String name, List<HomeAddress> homeAddress, List<Integer> marks) {
        this.name = name;
        this.homeAddress = homeAddress;
        this.marks = marks;
    }

    public Person(String name, List<HomeAddress> homeAddress, List<Integer> marks, String iCode) {
        this.name = name;
        this.homeAddress = homeAddress;
        this.marks = marks;
        this.iCode = iCode;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", homeAddress=" + homeAddress +
                ", marks=" + marks +
                ", iCode='" + iCode + '\'' +
                '}';
    }
}
