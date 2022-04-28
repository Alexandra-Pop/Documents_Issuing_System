package repository;

import entity.User;
import entity.UserRole;
import javax.persistence.*;
import java.util.List;

public class UserRepo {
	
	private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

	public void insertNewUser(User user, UserRole userRole) {
		user.setUserRole(userRole);
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

	public List<Object[]> getAllUsersByRole(UserRole userRole){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		TypedQuery<Object[]> query = em.createQuery("SELECT u.email, u.firstName, u.lastName from User u where u.userRole.id = '" + userRole.getId() + "'", Object[].class);
		List<Object[]> users = query.getResultList();

		em.getTransaction().commit();
		em.close();

		return users;
	}

	public User findUserById(String id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		em.getTransaction().commit();
		em.close();
		return user;
	}

	public String findUserByEmailAndPassword(String email, String password) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		TypedQuery<String> query = em.createQuery("SELECT u.id from User u where u.email = '" + email + "' and u.password = '" + password +"'", String.class);
		String id = null;
		try{
			id = query.getSingleResult();
		}
		catch (NoResultException ex){
			return null;
		}

		em.getTransaction().commit();
		em.close();

		return id;
	}

	public User findUserByEmail(String email) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		TypedQuery<User> query = em.createQuery("SELECT u from User u where u.email = '" + email + "'", User.class);
		User user = null;
		try{
			user = query.getSingleResult();
		}
		catch (NoResultException ex){}

		em.getTransaction().commit();
		em.close();

		return user;
	}

}
