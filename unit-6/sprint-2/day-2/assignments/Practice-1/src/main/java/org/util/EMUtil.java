package org.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("practice");
    }

    public static EntityManager getEntityManger(){
        return emf.createEntityManager();
    }
}
