package edu.com.softserveinc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

<<<<<<< HEAD
import edu.com.softserveinc.main.dao.QueryBuilder;
=======
import edu.com.softserveinc.main.dao.AddUserImpl;
>>>>>>> 27900e2a74d60055b05961e7c9535734872ccecf
import edu.com.softserveinc.main.models.UserModel;

import java.util.List; 

<<<<<<< HEAD
=======
import javax.servlet.http.HttpServletRequest;

>>>>>>> 27900e2a74d60055b05961e7c9535734872ccecf
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Controller
public class AdminToolpageController {
	private static SessionFactory factory;
	
	@RequestMapping(value = "/admin-toolpage", method = RequestMethod.GET)
	public String _method(Model model) {
	    factory = new AnnotationConfiguration().configure().addAnnotatedClass(UserModel.class).buildSessionFactory();
		Session session = factory.openSession();
	    Transaction tx = null;
	    tx = session.beginTransaction();
	    List users = session.createQuery(
	    		new QueryBuilder().from("users").toString()).list(); // generate sql query by query builder
	    model.addAttribute("Users", users);
	    tx.commit();
	    session.close();
		
		return "admin-toolpage";
	}
}
