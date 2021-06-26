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


@WebServlet("/usercon")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/project")
	private DataSource dataSource;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();

		switch (page) {
		case "login":
			loginFormLoader(request, response);
			break;
		case "signup":
			signUpFormLoader(request, response);
			break;
		case "userupd":
			UpdateUserFormLoader(request, response);
			break;	
		case "userdel":	
		     deleteuser(Integer.parseInt(request.getParameter("u_id")));
		     listuser(request, response);
		     break;	
		default:
			errorPage(request, response);
		}
		
	}

	
	private void listuser(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
			List<User> listuser = new ArrayList<>();
			listuser = new UserModel().listuser(dataSource);
			request.setAttribute("listuser", listuser);
			request.setAttribute("title", "List of users");
			request.getRequestDispatcher("userdisp.jsp").forward(request, response);
		
	}


	private void deleteuser(int u_id) {
		new UserModel().deleteuser(dataSource, u_id);
		return;
		
	}


	private void UpdateUserFormLoader(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("title", "Update user");
		try {
			request.getRequestDispatcher("updateuser.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void listuser(HttpServletRequest request, HttpServletResponse response, String u_id) 
		throws ServletException, IOException {
			List<User> listuser = new ArrayList<>();
			listuser = new UserModel().listuser1(dataSource, u_id);
			request.setAttribute("listuser", listuser);
			List<lending> listlen = new ArrayList<>();
			listlen = new OperationModel().listlen1(dataSource, u_id);
			request.setAttribute("listlen", listlen);
			request.setAttribute("title", "List of users");
			request.getRequestDispatcher("ulogedin.jsp").forward(request, response);
			
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String operation = request.getParameter("form");
		operation = operation.toLowerCase();
		switch (operation) {
		case "adduser":
			User newuser = new User(request.getParameter("u_id"), request.getParameter("name"), Integer.parseInt(request.getParameter("age")), Long.parseLong(request.getParameter("phone")), request.getParameter("address"), request.getParameter("password"));
			addUserOperation(newuser);
			usignedup(request,response);
			break;
		case "userlogin":
			User loginuser = new User(request.getParameter("u_id"), request.getParameter("password"));
			String s = request.getParameter("u_id");
			session.setAttribute("MyAttribute", s);
			String obj = (String) session.getAttribute("MyAttribute");
			loginUserOperation(loginuser);
			if(loginUserOperation(loginuser)) {
			//ulogedin(request,response);
			listuser(request, response, obj);	
			}
			else {
			again(request,response);
			}
			break;
		case "updateuser":
			User newuser1 = new User(request.getParameter("u_id"), request.getParameter("name"), Integer.parseInt(request.getParameter("age")), Long.parseLong(request.getParameter("phone")), request.getParameter("address"), request.getParameter("password"));
			updateUserOperation(newuser1);
			String obj1 = (String) session.getAttribute("MyAttribute");
			listuser1(request, response, obj1);
		default:
			errorPage(request, response);
			break;
		}
	}
	
	private void listuser1(HttpServletRequest request, HttpServletResponse response, String u_id) 
		throws ServletException, IOException {
			List<User> listuser = new ArrayList<>();
			listuser = new UserModel().listuser1(dataSource, u_id);
			request.setAttribute("listuser", listuser);
			request.setAttribute("title", "List of users");
			request.getRequestDispatcher("afteruup.jsp").forward(request, response);
		
	}


	private void updateUserOperation(User newuser1) {
		new UserModel().updateuser(dataSource,newuser1);
		return;
		
	}


	private void again(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			request.setAttribute("title", "Wrong page");
			request.getRequestDispatcher("again.jsp").forward(request, response);
		
	}

	private void addUserOperation(User newuser) {
		new UserModel().signup(dataSource, newuser);
		return;
	}
	
	private boolean loginUserOperation(User loginuser) {
		boolean a= new UserModel().login(dataSource, loginuser);
		return a;
	}
	
	public void usignedup(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> listuser = new ArrayList<>();
		listuser = new UserModel().listuser(dataSource);
		request.setAttribute("listuser", listuser);
		request.setAttribute("title", "List of users");
		request.getRequestDispatcher("usignedup.jsp").forward(request, response);
	}
		
//	public void ulogedin(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setAttribute("title", "Loged In");
//		request.getRequestDispatcher("ulogedin.jsp").forward(request, response);
//	}

	public void signUpFormLoader(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Sign Up");
		request.getRequestDispatcher("usignup.jsp").forward(request, response);
	}
		
     public void loginFormLoader(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.setAttribute("title", "Login");
			request.getRequestDispatcher("ulogin.jsp").forward(request, response);
		}
		
     public void errorPage(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.setAttribute("title", "Error page");
			request.getRequestDispatcher("error.jsp").forward(request, response);

		}
}
