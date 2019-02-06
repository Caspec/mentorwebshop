package iFace;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public interface IEntity {
     public void addEntityManagerFactory(EntityManagerFactory emf);
     public EntityManager getEntityManager();
}
