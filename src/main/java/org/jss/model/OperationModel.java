package org.jss.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.jss.entity.*;

public class OperationModel {
	
	public void addbook(DataSource dataSource, book newbook) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			int book_id = newbook.getBook_id();
			String title = newbook.getTitle();
			String author = newbook.getAuthor();
			String publish = newbook.getPublish();
			int copies = newbook.getCopies();
			String category = newbook.getCategory();
			String query = "insert into book (book_id,title,author,publish,copies,category) values (?,?,?,?,?,?)";
			statement = connect.prepareStatement(query);
			statement.setInt(1, book_id);
			statement.setString(2, title);
			statement.setString(3, author);
			statement.setString(4, publish);
			statement.setInt(5, copies);
			statement.setString(6, category);
			statement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<book> listbook(DataSource dataSource) {
		// Step 1: Initialize connection objects
		List<book> listbook = new ArrayList<>(); 
        Connection connect = null;
        Statement stmt = null;
        ResultSet rs = null;       
        try {
			connect = dataSource.getConnection();			
			// Step 2: Create a SQL statements string
			String query = "Select * from book";
			stmt = connect.createStatement();
			// Step 3: Execute SQL query
         rs = stmt.executeQuery(query);
			// Step 4: Process the result set
			while(rs.next()){
				listbook.add(new book(rs.getInt("book_id"), rs.getString("title"), rs.getString("author"), rs.getString("publish"), rs.getInt("copies"), rs.getString("category")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return listbook;
	}
	public void updatebook(DataSource dataSource, book updatebook) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			int book_id = updatebook.getBook_id();
			String title = updatebook.getTitle();
			String author = updatebook.getAuthor();
			String publish = updatebook.getPublish();
			int copies = updatebook.getCopies();
			String category = updatebook.getCategory();
			String query = "update book set title = ? , author = ?, publish = ?, copies = ?, category = ? where book_id = ? ";
			statement = connect.prepareStatement(query);
			statement.setString(1, title);
			statement.setString(2, author);
			statement.setString(3, publish);
			statement.setInt(4, copies);
			statement.setString(5, category);
			statement.setInt(6, book_id);
			statement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}

	public void deletebook(DataSource dataSource, int book_id) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String query = "delete from book where book_id = ? ";
			statement = connect.prepareStatement(query);
			statement.setInt(1, book_id);
			statement.execute();	
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void add(DataSource dataSource, lending newlen) {
		Connection connect = null;
		PreparedStatement statement = null;
		LocalDate myObj = LocalDate.now();
		Date date = java.sql.Date.valueOf(myObj);
		try {
			connect = dataSource.getConnection();
			int b_id = newlen.getB_id();
			String us_id = newlen.getUs_id();
			Date date_out = date;
			Date due_date = newlen.getDue_date();
			String query = "insert into borrow (book_id,u_id,date_out,due_date) values (?,?,?,?)";
			statement = connect.prepareStatement(query);
			statement.setInt(1, b_id);
			statement.setString(2, us_id);
			statement.setDate(3, new java.sql.Date(date_out.getTime()));
			statement.setDate(4, new java.sql.Date(due_date.getTime()));
			statement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<lending> listlen(DataSource dataSource) {
		// Step 1: Initialize connection objects
		List<lending> listlen = new ArrayList<>(); 
        Connection connect = null;
        Statement stmt = null;
        ResultSet rs = null;       
        try {
			connect = dataSource.getConnection();			
			// Step 2: Create a SQL statements string
			String query = "Select * from borrow";
			stmt = connect.createStatement();
			// Step 3: Execute SQL query
         rs = stmt.executeQuery(query);
			// Step 4: Process the result set
			while(rs.next()){
				listlen.add(new lending(rs.getInt("book_id"), rs.getString("u_id"), rs.getDate("date_out"), rs.getDate("due_date")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return listlen;
	}
	public List<lending> listlen1(DataSource dataSource, String u_id) {
		// Step 1: Initialize connection objects
		List<lending> listlen = new ArrayList<>(); 
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet rs = null;       
        try {
			connect = dataSource.getConnection();			
			// Step 2: Create a SQL statements string
			String query = "Select * from borrow where u_id = ?";
			statement = connect.prepareStatement(query);
			statement.setString(1, u_id);
			rs = statement.executeQuery();
			// Step 4: Process the result set
			while(rs.next()){
				listlen.add(new lending(rs.getInt("book_id"), rs.getDate("date_out"), rs.getDate("due_date")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return listlen;
	}

	public void update(DataSource dataSource, lending updatelen) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			int b_id = updatelen.getB_id();
			String us_id = updatelen.getUs_id();
			Date date_out = updatelen.getDay_out();
			Date due_date = updatelen.getDue_date();
			String query = "update book set date_out = ? , due_date = ? where bookid = ? and u_id = ?";
			statement = connect.prepareStatement(query);
			statement.setDate(1, new java.sql.Date(date_out.getTime()));
			statement.setDate(2, new java.sql.Date(due_date.getTime()));
			statement.setInt(3, b_id);
			statement.setString(4, us_id);
			statement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}

	public void delete(DataSource dataSource, int us_id, int b_id) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String query = "delete from borrow where book_id = ? and u_id = ? ";
			statement = connect.prepareStatement(query);
			statement.setInt(1, b_id);
			statement.setInt(2, us_id);
			statement.execute();	
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
}
