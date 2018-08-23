package co.grandcircus.coffeeshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.coffeeshop.dao.ItemsDaoJPA;
import co.grandcircus.coffeeshop.dao.UsersDaoJPA;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CoffeeShopController {
	
	@Autowired
	private ItemsDaoJPA itemsDaoJPA;
	
	@Autowired
	private UsersDaoJPA usersDaoJPA;

	
	@RequestMapping("/")
	public ModelAndView showHomePage() {
			List<Item> item = itemsDaoJPA.findAll();
			return new ModelAndView("index", "items", item);
		}
	
	@RequestMapping("/registrationform")
	public ModelAndView registrationform() {
		ModelAndView mav = new ModelAndView("registrationform");
		return mav;
	}	
	
	@RequestMapping("/regsummary")
	public ModelAndView regsummary(
			@RequestParam("firstName") String firstName, 
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email,
			@RequestParam("phone") int phone) {
//			@RequestParam("password") String password) {
//			@RequestParam("password2") String password2) {
		
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setPhone(phone);
//			user.setPassword(password);
//			user.setPassword2(password2);
			System.out.println(user);
			ModelAndView mav = new ModelAndView("regsummary");
			mav.addObject("user", user);
			usersDaoJPA.create(user);
			return mav;		
	}
	
	@RequestMapping("/pricing")
	public ModelAndView pricing() {
		ModelAndView mav = new ModelAndView("pricing");
		return mav;
	}
	
	@RequestMapping("/items/{id}/delete")
	public ModelAndView delete(@PathVariable("id") int id) {
		itemsDaoJPA.deleteById(id);
		return new ModelAndView("redirect:/");
	}
	
	
	@RequestMapping("/adds-items")
	public ModelAndView showAddItems() {
		ModelAndView mav = new ModelAndView("adds-items"); 
		return mav;
	}
	
	@RequestMapping("/add-for")
	public ModelAndView showAddForm(@RequestParam("name") String name, 
			@RequestParam("description") String description,
			@RequestParam("quantity") int quantity, @RequestParam("price") double price) {
		ModelAndView mav = new ModelAndView("redirect:/");
		
		Item item = new Item();
		item.setName(name);
		item.setDescription(description);
		item.setQuantity(quantity);
		item.setPrice(price);
		itemsDaoJPA.create(item);
		
		
			
		 return mav;
	}
	
	
	

	
}
