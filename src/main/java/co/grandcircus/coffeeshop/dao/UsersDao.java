package co.grandcircus.coffeeshop.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.User;

@Repository
public class UsersDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<User> findAll() {
		String sql = "SELECT * FROM users";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
	}
	
	public User findById(Integer id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
	}
	
	public User findByFirstName(String firstName) {
		String sql = "SELECT * FROM users WHERE firstName = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), firstName);
	}
	
	public User findByLastName(String lastName) {
		String sql = "SELECT * FROM users WHERE lastName = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), lastName);
	}
	
	public User findByEmail(Integer email) {
		String sql = "SELECT * FROM users WHERE email = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), email);
	}
	
	public void create(User user) {
		String sql ="INSERT INTO users(firstName, lastName, email) VALUES (?,?,?)";
		jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail());
	}
	
	public void delete(Integer id) {
		String sql ="DELETE FROM users WHERE id=?";
		jdbcTemplate.update(sql, id);
		
	}
}

