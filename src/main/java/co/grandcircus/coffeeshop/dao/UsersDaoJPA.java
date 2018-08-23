package co.grandcircus.coffeeshop.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import co.grandcircus.coffeeshop.User;

@Repository
@Transactional
public class UsersDaoJPA {

	@PersistenceContext
	EntityManager em;
		
	public List<User> findAll() {
		return em.createQuery("FROM User", User.class).getResultList();
	}
	
	public User findById(Integer id) {
		return em.find(User.class, id);
	}
	
	public User findByFirstName(String firstName) {
		return em.find(User.class,  firstName);
	}
	
	public User findByLastName(String lastName) {
		return em.find(User.class, lastName);
	}
	
	public User findByEmail(Integer email) {
		return em.find(User.class, email);
	}
	
	public void create(User user) {
		em.merge(user);
	}
	
	public void deleteById(Integer id) {
		User userToDelete = em.getReference(User.class, id);
		em.remove(userToDelete);
		
	}


}

