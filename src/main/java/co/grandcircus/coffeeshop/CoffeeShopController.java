package co.grandcircus.coffeeshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.coffeeshop.dao.ItemsDao;
import co.grandcircus.coffeeshop.dao.UsersDao;
import co.grandcircus.coffeeshop.entity.Item;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CoffeeShopController {
	
	@Autowired
	private ItemsDao itemsDao;
	
	@Autowired
	private UsersDao usersDao;

	
	@RequestMapping("/")
	public ModelAndView showHomePage() {
			List<Item> item = itemsDao.findAll();
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
			@RequestParam("email") String email) {
//			@RequestParam("phone") String phone
//			@RequestParam("password") String password) {
//			@RequestParam("password2") String password2) {
		
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
//			user.setPhone(phone);
//			user.setPassword(password);
//			user.setPassword2(password2);
			
			ModelAndView mav = new ModelAndView("regsummary");
			mav.addObject("user", user);
			usersDao.create(user);
			return mav;		
	}
	
	@RequestMapping("/pricing")
	public ModelAndView pricing() {
		ModelAndView mav = new ModelAndView("pricing");
		return mav;
	}
	

	
}
