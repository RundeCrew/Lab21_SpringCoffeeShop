package co.grandcircus.coffeShop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class coffeeShopController {

	
	@RequestMapping("/")
	public ModelAndView showHomePage() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@RequestMapping("/registrationform")
	public ModelAndView registrationform() {
		ModelAndView mav = new ModelAndView("registrationform");
		return mav;
	}
	
	@RequestMapping("/regsummary")
	public ModelAndView regsummary(@RequestParam("firstName") String firstName, 
										@RequestParam("lastName") String lastName,
										@RequestParam("email") String email,
										@RequestParam("phone") String phone,
										@RequestParam("password") String password) {
		
		ModelAndView mav = new ModelAndView("regsummary");
		mav.addObject("firstName", firstName);
		mav.addObject("lastName", lastName);
		mav.addObject("email", email);
		mav.addObject("phone", phone);
		mav.addObject("password", password);
		return mav;
	}
	
}
