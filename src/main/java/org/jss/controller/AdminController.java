package org.jss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


import org.jss.entity.*;
import org.jss.model.*;


@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/project")
	private DataSource dataSource;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String page = request.getParameter("page");
		page = page.toLowerCase();

		switch (page) {
		case "login":
			loginFormLoader(request, response);
			break;
		case "signup":
			signUpFormLoader(request, response);
			break;
		case "adminrud":
			String obj = (String) session.getAttribute("MyAttribute");
			listadmin(request, response, obj);
			break;
		case "adminupd":
			updateAdminFormLoader(request, response);
			break;
		case "admindel":
			delete(request.getParameter("username"));
			String object = (String) session.getAttribute("MyAttribute");
		    listadmin(request, response, object);
		    break;
		case "menu":
			logedin(request, response);
			break;
		default:
			errorPage(request, response);
		}
	}
	
	

	private void delete(String username) {
		new AdminModel().delete(dataSource,username);
		return;
		
	}



	private void updateAdminFormLoader(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("title", "Update admin");
		try {
			request.getRequestDispatcher("updatead.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void listadmin(HttpServletRequest request, HttpServletResponse response, String obj) 
			throws ServletException, IOException {
		List<admin> listadmin = new ArrayList<>();
		listadmin = new AdminModel().listadmin1(dataSource, obj);
		request.setAttribute("listadmin", listadmin);
		request.setAttribute("title", "List of admins");
		request.getRequestDispatcher("listad.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String operation = request.getParameter("form");
		operation = operation.toLowerCase();
		switch (operation) {
		case "addadmin":
			admin newadmin = new admin(request.getParameter("username"), request.getParameter("password"));
			addAdminOperation(newadmin);
			signedup(request,response);
			break;
		case "adminlogin":
			admin loginadmin = new admin(request.getParameter("username"), request.getParameter("password"));
			String name = request.getParameter("username");
			session.setAttribute("MyAttribute", name);
			loginAdminOperation(loginadmin);
			if(loginAdminOperation(loginadmin)) {
			logedin(request,response);
			}
			else {
			again(request,response);
			}
			break;
		case "adminup":
			admin updateadmin = new admin(request.getParameter("username"), request.getParameter("password"));
			updateAdminOperation(updateadmin);
			String obj = (String) session.getAttribute("MyAttribute");
			listadmin(request,response,obj);
			break;
		default:
			errorPage(request, response);
			break;
		}
	}
	
	private void updateAdminOperation(admin updateadmin) {
		new AdminModel().update(dataSource,updateadmin);
		return;
		
	}



	private void again(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			request.setAttribute("title", "Wrong page");
			request.getRequestDispatcher("again.jsp").forward(request, response);
		
	}

	private void addAdminOperation(admin newadmin) {
		new AdminModel().signup(dataSource, newadmin);
		return;
	}
	private boolean loginAdminOperation(admin loginadmin) {
		boolean a= new AdminModel().login(dataSource, loginadmin);
		return a;
	}
	
	public void signedup(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<admin> listadmin = new ArrayList<>();
		listadmin = new AdminModel().listadmin(dataSource);
		request.setAttribute("listadmin", listadmin);
		request.setAttribute("title", "List of admins");
		request.getRequestDispatcher("signedup.jsp").forward(request, response);
	}
		
	public void logedin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Loged In");
		request.getRequestDispatcher("logedin.jsp").forward(request, response);
	}
		

		public void signUpFormLoader(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.setAttribute("title", "Sign Up");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
			
	     public void loginFormLoader(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				request.setAttribute("title", "Login");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
	     public void errorPage(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				request.setAttribute("title", "Error page");
				request.getRequestDispatcher("error.jsp").forward(request, response);

			}
	
	}

