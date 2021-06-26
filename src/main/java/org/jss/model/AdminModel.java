package org.jss.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javax.sql.DataSource;

import org.jss.entity.*;
public class AdminModel {
	
	public List<admin> listadmin(DataSource dataSource) {
		// Step 1: Initialize connection objects
		List<admin> listadmin = new ArrayList<>(); 
        Connection connect = null;
        Statement stmt = null;
        ResultSet rs = null;       
        try {
			connect = dataSource.getConnection();			
			// Step 2: Create a SQL statements string
			String query = "Select * from admin";
			stmt = connect.createStatement();
			// Step 3: Execute SQL query
         rs = stmt.executeQuery(query);
			// Step 4: Process the result set
			while(rs.next()){
				listadmin.add(new admin(rs.getString("username")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return listadmin;
	}
	
	
	public void signup(DataSource dataSource, admin newadmin) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String username = newadmin.getUsername();
			String password = newadmin.getPassword();
			String query = "insert into admin (username,password) values (?,?)";
			statement = connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean login(DataSource dataSource, admin loginadmin) {
		Connection connect = null;
		PreparedStatement statement = null;
		ResultSet rs = null;  
       boolean a=false;
		try {
			connect = dataSource.getConnection();
			String username = loginadmin.getUsername();
			String password = loginadmin.getPassword();
			String query = "Select * from admin where username=?";
			statement = connect.prepareStatement(query);
			statement.setString(1, username);
			rs = statement.executeQuery();
			while(rs.next()) {
			if(rs.getString("username").equals(username) && rs.getString("password").equals(password)){
				a=true;
			}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public List<admin> listadmin1(DataSource dataSource, String obj) {
		List<admin> listadmin = new ArrayList<>(); 
		Connection connect = null;
		PreparedStatement statement = null;
		 ResultSet rs = null; 
		try {
			connect = dataSource.getConnection();
			String query = "Select * from admin where username=? ";
			statement = connect.prepareStatement(query);
			statement.setString(1, obj);
			rs = statement.executeQuery();
			while(rs.next()){
				listadmin.add(new admin(rs.getString("username"), rs.getString("password")));
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listadmin;
	}
	
	public void update(DataSource dataSource, admin newadmin) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String username = newadmin.getUsername();
			String password = newadmin.getPassword();
			String query = "update admin set password = ? where username = ? ";
			statement = connect.prepareStatement(query);
			statement.setString(2, username);
			statement.setString(1, password);
			statement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(DataSource dataSource, String username) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String query = "delete from admin where username = ? ";
			statement = connect.prepareStatement(query);
			statement.setString(1, username);
			statement.execute();	
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	
}
}

