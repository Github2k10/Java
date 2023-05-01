package org.dao;

import org.module.Course;
import org.module.Passport;
import org.module.Student;
import org.util.EMUtil;

import javax.persistence.EntityManager;

public class StudentDAO {
    public Student insertStudent(Student student){
        EntityManager em = EMUtil.getEntityManger();

        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();

        return student;
    }
}
