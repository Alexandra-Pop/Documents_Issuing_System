package repository;

import entity.Residence;
import javax.persistence.*;

public class ResidenceRepo {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void addResidence(Residence residence){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(residence);
        em.getTransaction().commit();
        em.close();
    }

    public Residence findResidence(String street, int number){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Residence> query = em.createQuery("SELECT u from Residence u where u.street = '" + street + "' and u.number = '" + number + "'", Residence.class);
        Residence residence = null;
        try{
            residence = query.getSingleResult();
        }
        catch (NoResultException ex){}

        em.getTransaction().commit();
        em.close();

        return residence;
    }

    public int deleteResidence(String residenceId){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("DELETE from Residence u WHERE u.id = '" + residenceId + "'");
        int deletedCount = query.executeUpdate();

        em.getTransaction().commit();
        em.close();

        return deletedCount;
    }

}
