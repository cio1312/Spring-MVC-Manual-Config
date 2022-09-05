package com.springmvc.basics.listener;
// we use listener conecpt to save data since we are not using database here 

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.springmvc.basics.entity.todo;

// ServletContextListener : as soon an obj is created , this class will listen to it. this object is kept till our website is on
//only one object of ServletContextListener is ,made for my whole website.


public class Listener implements ServletContextListener { 

	public void contextInitialized(ServletContextEvent sce) { // inbuilt method. automatic this method is called when obj is created
		
		System.out.println("contextInitialized ");  // you have to menbtion this listener in .xml file too
		List<todo> list = new ArrayList<todo>();
		ServletContext cont = sce.getServletContext(); // the object created initially of ServletContextListener , we fetch it here.
		cont.setAttribute("list", list); // creats a blank array list of TODO as soon as we run the code 
	}

	public void contextDestroyed(ServletContextEvent sce) { // inbuilt method
	
		
	}

}
