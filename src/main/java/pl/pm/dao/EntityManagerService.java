package pl.pm.dao;

import javax.persistence.EntityManagerFactory;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class EntityManagerService {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = createEntityManagerFactory("jpa.hibernate");

    public static EntityManagerFactory getEntityManagerFactory() {
        return ENTITY_MANAGER_FACTORY;
    }

    public static void close() {
     ENTITY_MANAGER_FACTORY.close();
    }


}
