
package co.grandcircus.coffeeshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.Item;

@Repository
public class ItemsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Item> findAll() {
		String sql = "SELECT * FROM items";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Item.class));
	}
	
	public Item findById(Integer id) {
		String sql = "SELECT * FROM items WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Item.class), id);
	}
	
	public Item findByName(String name) {
		String sql = "SELECT * FROM items WHERE name = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Item.class), name);
	}
	
	public Item findByDescription(String description) {
		String sql = "SELECT * FROM items WHERE description = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Item.class), description);
	}
	
	public Item findByQuantity(Integer quantity) {
		String sql = "SELECT * FROM items WHERE quantity = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Item.class), quantity);
	}
	
	public void create(Item item) {
		String sql ="INSERT INTO items(name, capacity, available) VALUES (?,?,?)";
		jdbcTemplate.update(sql, item.getName(), item.getDescription(), item.getQuantity());
	}
	
	public void delete(Integer id) {
		String sql ="DELETE FROM items WHERE id=?";
		jdbcTemplate.update(sql, id);
		
	}
}
