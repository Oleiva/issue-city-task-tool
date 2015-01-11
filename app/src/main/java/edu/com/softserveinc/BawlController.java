package edu.com.softserveinc;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.com.softserveinc.main.dao.users.GetUserByIdImpl;
import edu.com.softserveinc.main.dao.users.LoadUsersListImpl;
import edu.com.softserveinc.main.dao.users.UserServiceImpl;
import edu.com.softserveinc.main.models.UserModel;

@Controller
public class BawlController {
	private String notificationMessage;

	//TODO: change  "UserServiceImpl" on "AdminService"
	@RequestMapping(value = "/admin-toolpage")
	public String showUsersTable(LoadUsersListImpl usersList, Model model) {
		try {
			model.addAttribute("users", usersList.loadUsersList());
		} catch (JDBCConnectionException ex) {
			
			// TODO: Change it on logger!
			System.out
					.println("ERROR! Can't connect to database, try to change "
							+ "your login and password from MySQL-server in hibernata.cfg.xml");

			return "error";
		}
		notificationMessage = "";
		return "admin-toolpage";
	}
	//TODO: change  "UserServiceImpl" on "AdminService"
	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") UserModel user,
			UserServiceImpl userService, Model model) {

		userService.addUser(user);
		notificationMessage = "New user was succesfully added!";

		return "redirect:admin-toolpage";
	}

	//TODO: change  "UserServiceImpl" on "AdminService"
	@RequestMapping(value = "/edit-user", method = RequestMethod.POST)
	public String editUser(@RequestParam("userId") int userId, @RequestParam("change_firstname") String name,
			@RequestParam("change_email") String email, @RequestParam("change_login") String login,
				UserServiceImpl userService, GetUserByIdImpl getUsr, UserModel user, Model model) {
		try {
			user = getUsr.getUserByID(userId);
			user.setName(name);
			user.setEmail(email);
			user.setLogin(login);
			userService.editUser(user);
			notificationMessage = "User was succesfully edited!";
		} catch (Exception ex) {
			notificationMessage = "Error!" + ex.getCause();
		}
		return "redirect:admin-toolpage";
	}

	//TODO: change  "UserServiceImpl" on "AdminService"
	@RequestMapping(value = "/remove-user", method = RequestMethod.POST)
	public String removeUser(@RequestParam("userId") int userId,
			UserServiceImpl userService, GetUserByIdImpl getUsr, Model model) {

		userService.deleteUser(getUsr.getUserByID(userId));
		notificationMessage = "User was succesfully removed!";

		return "redirect:admin-toolpage";
	}
	
	@ModelAttribute
	public void addString(Model model) {
		model.addAttribute("notMsg", notificationMessage);
	}

}