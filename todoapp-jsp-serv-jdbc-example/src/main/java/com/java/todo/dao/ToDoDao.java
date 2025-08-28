package com.java.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.todo.connector.ConnectorFactory;
import com.java.todo.model.BasicDetails;


public class ToDoDao {
	Connection con = null;
	
	public int insertData(BasicDetails bds) 
	{
		int res = 0;
		try {
			con = ConnectorFactory.requestConnection();
			String query = "insert into todo_table values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, bds.getFirstname());
			pstmt.setString(2, bds.getLastname());
			pstmt.setString(3, bds.getUsername());
			pstmt.setString(4, bds.getPassword());
			res = pstmt.executeUpdate();			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	public boolean validate(String username, String password)
	{
		try
		{
			con = ConnectorFactory.requestConnection();
			String query = "select * from todo_table where username = ? and password = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet res = pstmt.executeQuery();
			if(res.next() == true)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
