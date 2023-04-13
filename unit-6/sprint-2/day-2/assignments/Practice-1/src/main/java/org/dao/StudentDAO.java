package org.dao;

import org.module.Address;
import org.module.Student;
import org.util.EMUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class StudentDAO {

    public String insertStudent(Student student){
        EntityManager em = EMUtil.getEntityManger();

        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();

        return "student added";
    }
}
