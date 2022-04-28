package repository;

import entity.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class UserResidenceRepo {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public List<Object[]> getAllResidencesByUserId(String id){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Object[]> query = em.createQuery("SELECT u.residence.street, u.residence.number from UserResidence u where u.user.id = '" + id + "'", Object[].class);
        List<Object[]> residences = new ArrayList<Object[]>();
         try{
            residences = query.getResultList();
        }
        catch (NoResultException ex){}

        em.getTransaction().commit();
        em.close();

        return residences;
    }

    public List<Object[]> getAllUsersByResidenceId(String id){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Object[]> query = em.createQuery("SELECT u.user from UserResidence u where u.residence.id = '" + id + "'", Object[].class);
        List<Object[]> users = new ArrayList<Object[]>();
        try{
            users = query.getResultList();
        }
        catch (NoResultException ex){}

        em.getTransaction().commit();
        em.close();

        return users;
    }

    public void insertNewUserResidence(User user, Residence residence){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(new UserResidence(user, residence));
        em.getTransaction().commit();
        em.close();
    }

    public UserResidence findUserResidenceByResidenceAndUserId(String userId, String residenceId){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<UserResidence> query = em.createQuery("SELECT u from UserResidence u where u.user.id = '" + userId + "' and u.residence.id = '" + residenceId + "'", UserResidence.class);
        UserResidence userResidence = null;
        try{
            userResidence = query.getSingleResult();
        }
        catch (NoResultException ex){}

        em.getTransaction().commit();
        em.close();

        return userResidence;
    }

    public int deleteUserResidenceById(String userId, String residenceId){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("DELETE from UserResidence u WHERE u.user.id = '" + userId + "' and u.residence.id = '" + residenceId + "'");
        int deletedCount = query.executeUpdate();

        em.getTransaction().commit();
        em.close();

        return deletedCount;
    }

}
