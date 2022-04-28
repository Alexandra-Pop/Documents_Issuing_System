package repository;

import entity.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserResidenceDocumentRepo {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewUserResidenceDocument(UserResidence userResidence, Document document){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        UserResidenceDocument userResidenceDocument = new UserResidenceDocument(userResidence, document, LocalDate.now().toString());
        em.persist(userResidenceDocument);
        em.getTransaction().commit();
        em.close();
    }

    public UserResidenceDocument findRequestsByDate(UserResidence userResidence, Document document, String date){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<UserResidenceDocument> query = em.createQuery("SELECT u from UserResidenceDocument u where u.userResidence.id = '" + userResidence.getId() + "' and u.document.id = '" + document.getId() + "' and u.date = '" + date + "'", UserResidenceDocument.class);
        UserResidenceDocument userResidenceDocument = null;
        try{
            userResidenceDocument = query.getSingleResult();
        }
        catch (NoResultException ex){}

        em.getTransaction().commit();
        em.close();

        return userResidenceDocument;
    }

    public List<Object[]> getUsersRequests(String userId){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Object[]> query = em.createQuery("SELECT u.userResidence.user.email, u.userResidence.user.firstName, u.userResidence.user.lastName, u.userResidence.residence.street, u.userResidence.residence.number, u.document.type, u.document.description, u.request, u.date from UserResidenceDocument u where u.userResidence.user.id = '" + userId + "'", Object[].class);
        List<Object[]> requests = new ArrayList<Object[]>();
        try{
            requests = query.getResultList();
        }
        catch (NoResultException ex){}

        em.getTransaction().commit();
        em.close();

        return requests;
    }

    public int getNbOfUsersRequestsInAYear(String userId, UserResidence userResidence, Document document, String date){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Object[]> query = em.createQuery("SELECT u from UserResidenceDocument u where u.userResidence.user.id = '" + userId + "' and year(u.date) = '" + date + "' and u.document.id = '" + document.getId() + "'" + " and u.userResidence.id = '" + userResidence.getId() + "'", Object[].class);
        List<Object[]> requests = new ArrayList<Object[]>();
        try{
            requests = query.getResultList();
        }
        catch (NoResultException ex){}

        em.getTransaction().commit();
        em.close();

        return requests.size();
    }

    public List<Object[]> getAllRequests(){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Object[]> query = em.createQuery("SELECT u.userResidence.user.email, u.userResidence.user.firstName, u.userResidence.user.lastName, u.userResidence.residence.street, u.userResidence.residence.number, u.document.type, u.document.description, u.request, u.date from UserResidenceDocument u", Object[].class);
        List<Object[]> requests = new ArrayList<Object[]>();
        try{
            requests = query.getResultList();
        }
        catch (NoResultException ex){}

        em.getTransaction().commit();
        em.close();

        return requests;
    }

    public int acceptRequest(UserResidence userResidence, Document document, String date){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE UserResidenceDocument u SET u.request = '0' WHERE u.userResidence.id = '" + userResidence.getId() + "' and u.document.id = '" + document.getId() + "' and u.date = '" + date + "'");
        int updatedCount = query.executeUpdate();
        em.getTransaction().commit();
        em.close();

        return updatedCount;
    }

    public int declineRequest(UserResidence userResidence, Document document, String date){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM UserResidenceDocument u WHERE u.userResidence.id = '" + userResidence.getId() + "' and u.document.id = '" + document.getId() + "' and u.date = '" + date + "'");
        int deletedCount = query.executeUpdate();
        em.getTransaction().commit();
        em.close();

        return deletedCount;
    }

    public int updateRequest(UserResidence userResidence, Document document, String date){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE UserResidenceDocument u SET u.date = '" + LocalDate.now().toString() + "' WHERE u.userResidence.id = '" + userResidence.getId() + "' and u.document.id = '" + document.getId() + "' and u.request = '1'" + " and u.date = '" + date + "'");
        int updatedCount = query.executeUpdate();
        em.getTransaction().commit();
        em.close();

        return updatedCount;
    }

}