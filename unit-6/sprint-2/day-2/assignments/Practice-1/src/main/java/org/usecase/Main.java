package org.usecase;

import org.dao.StudentDAO;
import org.module.Address;
import org.module.Student;
import org.util.EMUtil;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = EMUtil.getEntityManger();

        Address address = new Address();
        address.setAid(1);
        address.setState("Mumbai");
        address.setCity("Maharashtra");
        address.setPincode("147852369");

//        Address address1 = new Address();
//        address1.setAid(2);
//        address1.setState("Pune");
//        address1.setCity("Maharashtra");
//        address1.setPincode("147852369");

        Student student = new Student();
        student.setName("Ron");
        student.setAddress(address);

        Student student1 = new Student();
        student1.setName("Tom");
        student1.setAddress(address);

        Student student2 = new Student();
        student2.setName("Jon");
        student2.setAddress(address);

        em.getTransaction().begin();
        em.persist(student);
        em.persist(student1);
        em.persist(student2);
        em.getTransaction().commit();
        em.close();

        System.out.println(student);
        System.out.println(student1);
        System.out.println(student2);
    }
}
