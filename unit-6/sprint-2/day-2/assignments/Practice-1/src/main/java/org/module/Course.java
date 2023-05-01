package org.module;

import javax.persistence.*;

//@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;
    private String cname;
    private int c_class;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private Student student;

    public Course(){}

    public Course(String cname, int c_class, Student student) {
        this.cname = cname;
        this.c_class = c_class;
        this.student = student;
    }

    public int getId() {
        return cid;
    }

    public void setId(int id) {
        this.cid = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getC_class() {
        return c_class;
    }

    public void setC_class(int c_class) {
        this.c_class = c_class;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + cid +
                ", cname='" + cname + '\'' +
                ", c_class=" + c_class +
                '}';
    }
}
