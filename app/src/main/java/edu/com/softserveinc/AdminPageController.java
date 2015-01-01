package edu.com.softserveinc;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.com.softserveinc.main.models.UserModel;

/**
 * Handles requests for the application addUser page.
 */
@Controller
public class AdminPageController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminPageController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "addUser", method = RequestMethod.GET)
	public String addUser(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		UserModel user = new UserModel("Nazar","si@Ul.d","sss",1,"","");
		
		// test 
		model.addAttribute("userName", user.getName());
		model.addAttribute("userMail", "<b>"+user.getEmail()+"</b>");
		model.addAttribute("userLogin", user.getLogin());
		
		return "addUser";
	}
	
}