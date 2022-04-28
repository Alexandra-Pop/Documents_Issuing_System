package repository;

import entity.Document;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentRepo {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewDocument(Document document) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(document);
        em.getTransaction().commit();
        em.close();
    }

    public Document findDocument(String type, String description) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Document> query = em.createQuery("SELECT u from Document u where u.type = '" + type + "' and u.description = '" + description +"'", Document.class);
        Document document = null;
        try{
            document = query.getSingleResult();
        }
        catch (NoResultException ex){}

        em.getTransaction().commit();
        em.close();

        return document;
    }

    public List<Object[]> getAllDocuments(){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Object[]> query = em.createQuery("SELECT u.type, u.description from Document u", Object[].class);
        List<Object[]> documents = new ArrayList<Object[]>();
        try{
            documents = query.getResultList();
        }
        catch (NoResultException ex){}

        em.getTransaction().commit();
        em.close();

        return documents;
    }

    public int deleteDocument(Document document){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("DELETE from Document u WHERE u.type = '" + document.getType() + "' and u.description = '" + document.getDescription() + "'");
        int deletedCount = query.executeUpdate();

        em.getTransaction().commit();
        em.close();

        return deletedCount;
    }

}