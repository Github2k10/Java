package org.module;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private int marks;

    @Embedded
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "address", joinColumns = @JoinColumn(name = "Student_id"))
    private List<Address> address = new ArrayList<>();

    public Student(){}

    public Student(int id, String name, int marks, List<Address> address) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", address=" + address +
                '}';
    }
}
