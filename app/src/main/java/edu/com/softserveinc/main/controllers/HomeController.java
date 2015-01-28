package edu.com.softserveinc.main.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.com.softserveinc.main.models.CommentModel;
import edu.com.softserveinc.main.models.IssueModel;
import edu.com.softserveinc.main.services.CategoryServiceImpl;
import edu.com.softserveinc.main.services.CommentServiceImpl;
import edu.com.softserveinc.main.services.IssueServiceImpl;
import edu.com.softserveinc.main.utils.IssueValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, CategoryServiceImpl service) {
		List categoriesList = service.loadCategoriesList();
		model.addAttribute("categories", categoriesList);
		return "home";
	}

	@RequestMapping(value = "add-issue", method = RequestMethod.POST)
	public String addIssue(HttpServletRequest request, IssueServiceImpl service) {
		String issueName = request.getParameter("issueName");
		String issueCategory = request.getParameter("issueCategory");
		String issueDescription = request.getParameter("issueDescription");
		String issueResolution = request.getParameter("issueResolution");
		String issueAttachments = request.getParameter("issueAttachments");
		
		System.out.println(issueName);
		System.out.println(issueCategory);
		System.out.println(issueDescription);
		System.out.println(issueResolution);
		System.out.println(issueAttachments);
		
		IssueModel issue = new IssueModel(issueName, issueDescription, "0, 0",
				issueAttachments, 1);
		
		if (new IssueValidator(issue).isValid()) {
			try {
				service.addProblemm(issue);
			} catch (Exception ex) {
				System.out.println("ERROR" + ex.toString());
			}
		}
		else{

			System.out.println("Error! Issue is not valid!!!");
		}
		// TODO: add here notification method!
		return "home";
	}

	@RequestMapping(value = "get-issue", method = RequestMethod.POST)
	public @ResponseBody IssueModel getIssue(
			@RequestBody Map<String, Object> request,
			IssueServiceImpl issueService) {

		System.out.println(request.get("id"));

		IssueModel issue = new IssueModel();
		issue.setId(1);

		return issue;
	}
	
	//fetch all comments for issue-id
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "all-comments/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List getAllByIssueId(@PathVariable int id) {
		return new CommentServiceImpl().getCommentsByIssueId(id);
	}

	// adding comment for issue
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "add-comment", method = RequestMethod.POST)
	public @ResponseBody java.util.LinkedHashMap addComment(
			@RequestBody final java.util.LinkedHashMap comment) {
		int id = Integer.parseInt(comment.get("issueId").toString());
		new CommentServiceImpl().addComment(new CommentModel(comment.get(
				"comment").toString(), comment.get("userName").toString(),
				comment.get("email").toString(), id));
		System.out.println("email: " + comment.get("email") + "issue id: "
				+ comment.get("issueId"));
		return comment;
	}
}
