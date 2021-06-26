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

public class UserModel {
	
	public List<User> listuser(DataSource dataSource) {
		// Step 1: Initialize connection objects
		List<User> listuser = new ArrayList<>(); 
        Connection connect = null;
        Statement stmt = null;
        ResultSet rs = null;       
        try {
			connect = dataSource.getConnection();			
			// Step 2: Create a SQL statements string
			String query = "Select * from user";
			stmt = connect.createStatement();
			// Step 3: Execute SQL query
         rs = stmt.executeQuery(query);
			// Step 4: Process the result set
			while(rs.next()){
				listuser.add(new User(rs.getString("u_id"),rs.getString("name"),rs.getString("address")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return listuser;
	}
	
	
	public void signup(DataSource dataSource, User newuser) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String u_id = newuser.getU_id();
			String name = newuser.getName();
			int age = newuser.getAge();
			long phone = newuser.getPhone();
			String address = newuser.getAddress();
			String password = newuser.getPassword();
			String query = "insert into user (u_id,name,age,phone,address,password) values (?,?,?,?,?,?)";
			statement = connect.prepareStatement(query);
			statement.setString(1, u_id);
			statement.setString(2, name);
			statement.setInt(3, age);
			statement.setLong(4, phone);
			statement.setString(5, address);
			statement.setString(6, password);
			statement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean login(DataSource dataSource, User loginuser) {
		Connection connect = null;
		PreparedStatement statement = null;
		ResultSet rs = null;  
        boolean a = false;
		
        try {
			connect = dataSource.getConnection();
			String u_id = loginuser.getU_id();
			String password = loginuser.getPassword();
			String query = "Select * from user where u_id=?";
			statement = connect.prepareStatement(query);
			statement.setString(1, u_id);
			rs = statement.executeQuery();
			while(rs.next()) {
			if(rs.getString("u_id").equals(u_id) && rs.getString("password").equals(password)){
				a=true;
			}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public List<User> listuser1(DataSource dataSource, String u_id) {
		// Step 1: Initialize connection objects
		List<User> listuser = new ArrayList<>(); 
		Connection connect = null;
		PreparedStatement statement = null;
		ResultSet rs = null;       
        try {
        	connect = dataSource.getConnection();
			String query = "Select * from user where u_id = ?";
			statement = connect.prepareStatement(query);
			statement.setString(1, u_id);
			rs = statement.executeQuery();
			while(rs.next()){
				listuser.add(new User(rs.getString("u_id"),rs.getString("name"),rs.getInt("age"),rs.getLong("phone"),rs.getString("address"),rs.getString("password")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return listuser;
	}
	
	public void updateuser(DataSource dataSource, User newuser) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String u_id = newuser.getU_id();
			String name = newuser.getName();
			int age = newuser.getAge();
			long phone = newuser.getPhone();
			String address = newuser.getAddress();
			String password = newuser.getPassword();
			String query = "update user set name = ? , age = ?, phone = ?, address = ?, password = ? where u_id = ? ";
			statement = connect.prepareStatement(query);
			statement.setString(1, name);
			statement.setInt(2, age);
			statement.setLong(3, phone);
			statement.setString(4, address);
			statement.setString(5, password);
			statement.setString(6, u_id);
			statement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteuser(DataSource dataSource, int us_id) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String query = "delete from user where u_id = ? ";
			statement = connect.prepareStatement(query);
			statement.setInt(1, us_id);
			statement.execute();	
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}

}
