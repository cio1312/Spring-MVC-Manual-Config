package com.springmvc.basics;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.basics.entity.todo;
// by defualt the code goes to index.jsp
@Controller
public class springcontroller {

	@Autowired  // autowired will remove object of ServletContext   from IOC container and put in context. so that we can use it 
	ServletContext context;
	
	@RequestMapping("/home")
	public String home(Model m) { // view the concept of model and view. we use JSTL at front end to access at
									// front end
		System.out.println("inside home");
		String pageContent = "WELCOME TO TODO APPLICATION";
		m.addAttribute("pageContent", pageContent); // key value pair
		m.addAttribute("pagename", "home");
		return "home"; // from here it goes to view-resolver that is spring-servlet.xml . web.xml makes
						// it go to SpringController-servlet.xml

	}

	@RequestMapping("/add")
	public String add(Model m) {
		System.out.println("inside add");
		todo obj = new todo();
		m.addAttribute("todo", obj);
		String pageContent = "ADD TO YOUR LIST";
		m.addAttribute("pageContent", pageContent);
		m.addAttribute("pagename", "add");

		return "home";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST) // by efault RequestMetohd is GET but in form we said
																	// post , hence mentioning herew
	public String save(@ModelAttribute("todo") todo t, Model m) { // we have said
																	// modelAttribute="todo"> in
		System.out.println("inside save");												// form
		// t holds all data from form
		t.setDate(new Date());
		System.out.println("inside save" + t);
		// get the todo list from context
		List<todo> todolist = (List<todo>) context.getAttribute("list"); // we will get a list of todo array object
																			// here,. this was created as soon as
		System.out.println("inside save" + t);																// project was run. and only one copy of
																			// this is made.
		todolist.add(t); // now the list of obj that was created at start , we use to store data in it.
							// and this data will be there till the project is killed
		System.out.println("inside save" + t);

		m.addAttribute("pagename", "view");
		m.addAttribute("sucMsg", "Successfully Added");
		return "home";
	}

	@RequestMapping(value = "/view")
	public String view(Model m) {
		System.out.println("inside add");
		String pageContent = "THINGS TO DO";
		m.addAttribute("pageContent", pageContent);
		m.addAttribute("pagename", "view");
		List<todo> todolist = (List<todo>) context.getAttribute("list");
		m.addAttribute("TodoList",todolist);
		
		return "home";
	}

}