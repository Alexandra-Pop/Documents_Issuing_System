package repository;

import entity.UserRole;
import javax.persistence.*;

public class UserRoleRepo {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewRole(UserRole userRole){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(userRole);
        em.getTransaction().commit();
        em.close();
    }

    public UserRole findRoleByName(String roleName){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<UserRole> query = em.createQuery("SELECT u from UserRole u where u.roleName = '" + roleName +"'", UserRole.class);
        UserRole userRole = query.getSingleResult();
        em.getTransaction().commit();
        em.close();

        return userRole;
    }

    public String findRoleNameById(String id){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<String> query = em.createQuery("SELECT u.roleName from UserRole u where u.id = '" + id +"'", String.class);
        String userName = null;
        try{
            userName = query.getSingleResult();
        }
        catch (NoResultException ex){}
        em.getTransaction().commit();
        em.close();

        return userName;
    }

}
