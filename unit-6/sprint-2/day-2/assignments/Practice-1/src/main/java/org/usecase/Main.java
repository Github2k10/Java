package org.usecase;

import org.dao.StudentDAO;
import org.module.Address;
import org.module.Student;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        Address home = new Address();
        home.setState("Kolkata");
        home.setCity("Chennai");
        home.setPincode("110088");
        home.setType("home");

        Address office = new Address();
        office.setState("Koichi");
        office.setCity("Chennai");
        office.setPincode("110458");
        office.setType("office");

        Set<Address> set = new HashSet<>();
        set.add(home);
        set.add(office);

        Student student = new Student();
        student.setId(1);
        student.setName("Ron");
        student.setMarks(96);
        student.setAddress(set);

        String out = dao.insertStudent(student);

        System.out.println(out);
    }
}
