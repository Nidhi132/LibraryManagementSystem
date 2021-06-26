package org.jss.controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.jss.entity.*;
import org.jss.model.*;

@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/project")
	private DataSource dataSource;   
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();
		
		switch (page) {
		case "bookin":
			addBooksFormLoader(request, response);
			break;
		case "bookrud":
			listBooks(request, response);
			break;	
		case "booku":
			UpdateBookFormLoader(request, response);
			break;
		case "bookd":
			deleteBook(Integer.parseInt(request.getParameter("book_id")));
		     listBooks(request, response);
			break;
		case "issue":
			addFormLoader(request, response);
			break;
		case "issuerud":
			list(request, response);
			break;
		case "issueu":
			UpdateFormLoader(request, response);
			break;	
		case "issued":	
		     delete(Integer.parseInt(request.getParameter("b_id")),Integer.parseInt(request.getParameter("us_id")));
		     list(request, response);
		     break;
		default:
			errorPage(request, response);
		}
	}
	
	private void delete(int us_id, int b_id) {
		new OperationModel().delete(dataSource,us_id,b_id);
		return;
		
	}

	private void UpdateFormLoader(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("title", "Update lending");
		try {
			request.getRequestDispatcher("updatelen.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("form");
		operation = operation.toLowerCase();
		switch (operation) {
		case "addbook":
			book newbook = new book(Integer.parseInt(request.getParameter("book_id")), request.getParameter("title"), request.getParameter("author"), request.getParameter("publish"), Integer.parseInt(request.getParameter("copies")), request.getParameter("category"));
			addBooksOperation(newbook);
			listBooks(request, response);
			break;
		case "updatebook":
			book updatebook = new book(Integer.parseInt(request.getParameter("book_id")), request.getParameter("title"), request.getParameter("author"), request.getParameter("publish"), Integer.parseInt(request.getParameter("copies")), request.getParameter("category"));
			updateBookOperation(dataSource, updatebook);
			listBooks(request, response);
			break;
		case "add":
			try {
			String duedate = request.getParameter("due_date");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date due_date;
				due_date = (Date) dateFormat.parse(duedate);
			
			lending newlen = new lending(Integer.parseInt(request.getParameter("b_id")),request.getParameter("us_id"),due_date);
			lenaddOperation(newlen);
			list(request, response);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "update":
			try {
			String duedate = request.getParameter("due_date");
			String dateout = request.getParameter("day_out");
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			Date due_date; Date date_out;
			
				due_date = (Date) dateFormat1.parse(duedate);
				date_out = (Date) dateFormat1.parse(dateout);
			
			lending updatelen = new lending(Integer.parseInt(request.getParameter("b_id")),request.getParameter("us_id"),date_out,due_date);
			updatelenOperation(dataSource, updatelen);
			list(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			errorPage(request, response);
			break;
		}
	}
	

	private void updatelenOperation(DataSource dataSource2, lending updatelen) {
		new OperationModel().update(dataSource,updatelen);
		return;
		
	}

	private void lenaddOperation(lending newlen) {
		new OperationModel().add(dataSource, newlen);
		return;
		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<lending> listlen = new ArrayList<>();
		listlen = new OperationModel().listlen(dataSource);
		request.setAttribute("listlen", listlen);
		request.setAttribute("title", "List of lending");
		request.getRequestDispatcher("listlen.jsp").forward(request, response);
	
		
	}


	private void addFormLoader(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("title", "Add");
		request.getRequestDispatcher("add.jsp").forward(request, response);
		
	}


	private void deleteBook(int book_id) {
		new OperationModel().deletebook(dataSource, book_id);
		return;
		
	}


	private void listBooks(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
			List<book> listbooks = new ArrayList<>();
			listbooks = new OperationModel().listbook(dataSource);
			request.setAttribute("listbooks", listbooks);
			request.setAttribute("title", "List of books");
			request.getRequestDispatcher("listbook.jsp").forward(request, response);
		
	}


	private void UpdateBookFormLoader(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("title", "Update Book");
		try {
			request.getRequestDispatcher("updateBook.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void addBooksFormLoader(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("title", "Add Book");
		request.getRequestDispatcher("addBook.jsp").forward(request, response);
		
	}
	
	public void errorPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Error page");
		request.getRequestDispatcher("error.jsp").forward(request, response);

	}



	private void updateBookOperation(DataSource dataSource2, book updatebook) {
		new OperationModel().updatebook(dataSource,updatebook);
		return;
		
	}


	private void addBooksOperation(book newbook) {
		new OperationModel().addbook(dataSource, newbook);
		return;
		
	}

}
