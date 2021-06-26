package org.jss.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.jss.entity.book;

public class BookModel {
	
	public List<book> listbook(DataSource dataSource, String cat) {
		// Step 1: Initialize connection objects
		List<book> listbook = new ArrayList<>(); 
		Connection connect = null;
		PreparedStatement statement = null;
		ResultSet rs = null;       
        try {
        	connect = dataSource.getConnection();			
			// Step 2: Create a SQL statements string
			String query = "Select * from book where category = ? ";
			statement = connect.prepareStatement(query);
			statement.setString(1, cat);
			rs = statement.executeQuery();
			while(rs.next()){
				listbook.add(new book(rs.getInt("book_id"), rs.getString("title"), rs.getString("author"), rs.getString("publish"), rs.getInt("copies"), rs.getString("category")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return listbook;
	}

}
