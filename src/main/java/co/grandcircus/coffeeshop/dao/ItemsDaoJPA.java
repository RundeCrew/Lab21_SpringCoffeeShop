
package co.grandcircus.coffeeshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.Item;


@Repository
@Transactional
public class ItemsDaoJPA {

	@PersistenceContext
	private EntityManager em;
	
	public List<Item> findAll() {
		return em.createQuery("FROM Item", Item.class).getResultList();
		}
	
	public Item findById(Integer id) {
		return em.find(Item.class, id);
	}
	
	public Item findByName(String name) {
		return em.find(Item.class,  name);
	}
	
	public Item findByDescription(String description) {
		return em.find(Item.class, description);
	}
	
	public Item findByQuantity(Integer quantity) {
		return em.find(Item.class, quantity);
	}
	
	public void update(Item item) {
		em.merge(item);
	}
	
	public void create(Item item) {
		em.persist(item);
	}
	
	public void deleteById(Integer id) {
		Item itemToDelete = em.getReference(Item.class, id);
		em.remove(itemToDelete);
		
	}
}
