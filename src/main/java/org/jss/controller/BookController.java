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
import javax.sql.DataSource;

import org.jss.entity.book;
import org.jss.model.*;

@WebServlet("/book")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/project")
	private DataSource dataSource;   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();

		switch (page) {
		case "1":
			String cat = "Programming language";
			listBooks(request, response, cat);
			break;
		case "2":
			String cat1 = "Web related";
			listBooks(request, response, cat1);
			break;
		case "3":
			String cat2 = "Data structures";
			listBooks(request, response, cat2);
			break;
		case "4":
			String cat3 = "General";
			listBooks(request, response, cat3);
			break;	
		default:
			errorPage(request, response);
		}
	}
	
	private void listBooks(HttpServletRequest request, HttpServletResponse response, String cat) 
		throws ServletException, IOException {
			List<book> listbooks = new ArrayList<>();
			listbooks = new BookModel().listbook(dataSource,cat);
			request.setAttribute("listbooks", listbooks);
			request.setAttribute("title", "List of books");
			request.getRequestDispatcher("books.jsp").forward(request, response);
		
	}

	public void errorPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Error page");
		request.getRequestDispatcher("error.jsp").forward(request, response);

	}


}
