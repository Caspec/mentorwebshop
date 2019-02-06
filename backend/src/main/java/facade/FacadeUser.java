package facade;

import iFace.IUser;
import entity.User;
import iFace.IEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class FacadeUser implements IUser, IEntity {

    private EntityManagerFactory emf;

    public FacadeUser(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public FacadeUser() {

    }

    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT e.id, e.firstname, e.lastname, e.created_at, e.gender, e.status, e.roleId FROM User e");
            return (List<User>) query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<User> getUser(Long id) {
        EntityManager em = getEntityManager();
        List<User> ul = new ArrayList();
        try {
            Query query = em.createQuery("SELECT e.id, e.firstname, e.lastname, e.created_at, e.gender, e.status, e.roleId FROM User e WHERE e.id = :id", User.class);
            query.setParameter("id", id);
            ul = query.getResultList();
            return ul;
        } finally {
            em.close();
        }
    }

    @Override
    public User addUser(User user) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return user;
        } finally {
            em.close();
        }
    }

    @Override
    public User editUser(User user) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT e FROM User e WHERE e.id = :id", User.class);
            query.setParameter("id", user.getId());
            User u = (User) query.getSingleResult();
            if (u != null) {
                u = user;
                em.merge(u);
            }
            em.getTransaction().commit();
            return u;
        } finally {
            em.close();
        }
    }

    @Override
    public User deleteUser(User user) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT e FROM User e WHERE e.id = :id", User.class);
            query.setParameter("id", user.getId());
            User u = (User) query.getSingleResult();
            if (u != null) {
                em.remove(u);
            }
            em.getTransaction().commit();
            return u;
        } finally {
            em.close();
        }
    }
}
