package org.usecase;

import org.dao.StudentDAO;
import org.module.Address;
import org.module.Student;
import org.util.EMUtil;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

//        Address home = new Address();
//        home.setState("Kolkata");
//        home.setCity("Chennai");
//        home.setPincode("110088");
//        home.setType("home");
//
//        Address office = new Address();
//        office.setState("Koichi");
//        office.setCity("Chennai");
//        office.setPincode("110458");
//        office.setType("office");
//
//        Student student = new Student();
//        student.setId(1);
//        student.setName("Ron");
//        student.setMarks(96);
//        student.getAddress().add(home);
//        student.getAddress().add(office);
//
//        String out = dao.insertStudent(student);

        EntityManager em = EMUtil.getEntityManger();

        Student student = em.find(Student.class, 1);
        em.close();
        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getMarks());

        for(Address a : student.getAddress()){
            System.out.println(a);
        }
    }
}
