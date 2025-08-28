package com.java.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.java.todo.connector.ConnectorFactory;
import com.java.todo.model.TodoDetails;

public class TodocreateDaoImp implements TodocreateDao{

	Connection con = null;
	public List<TodoDetails> selectAll() {
		List<TodoDetails> ltd = new ArrayList<>();;
		try
		{
			con = ConnectorFactory.requestConnection();
			String query = "select * from listingtodo";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while(res.next() == true)
			{
				int id = res.getInt(1);
				String title = res.getString(2);
				String description = res.getString(3);
				LocalDate date = res.getDate(4).toLocalDate();
				boolean status = res.getBoolean(5);
				TodoDetails td = new TodoDetails(id, title, description, date, status);
				ltd.add(td);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ltd;
	}

	
	public void inserttodo(TodoDetails td) {
		try
		{
			con = ConnectorFactory.requestConnection();
			String query = "insert into listingtodo(`title`,`description`,`enddate`,`status`) values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, td.getTitle());
			pstmt.setString(2, td.getDescription());
			pstmt.setDate(3, ConnectorFactory.getSQLDate(td.getTargetDate()));
			pstmt.setBoolean(4, td.isStatus());
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public TodoDetails selecttodo(int id) {
		TodoDetails tcd = null;
		try
		{
			con = ConnectorFactory.requestConnection();
			String query = "select * from listingtodo where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			while(res.next() == true)
			{
				String title = res.getString(2);
				String description = res.getString(3);
				LocalDate date = res.getDate(4).toLocalDate();
				boolean status = res.getBoolean(5);
				tcd = new TodoDetails(id, title, description, date, status);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return tcd;
	}

	
	public boolean deletetodo(int id) {
		boolean rowupdated = false;
		try
		{
			con = ConnectorFactory.requestConnection();
			String query = "delete from listingtodo where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			rowupdated = pstmt.executeUpdate()>0;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowupdated;
	}

	public boolean updatetodo(TodoDetails td) {
		boolean rowupdated = false;
		try
		{
			con = ConnectorFactory.requestConnection();
			String query = "update listingtodo set title = ? , description =?, enddate=?,status=? where id= ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, td.getTitle());
			pstmt.setString(2, td.getDescription());
			pstmt.setDate(3, ConnectorFactory.getSQLDate(td.getTargetDate()));
			pstmt.setBoolean(4, td.isStatus());
			pstmt.setInt(5, td.getId());
			rowupdated = pstmt.executeUpdate() > 0;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowupdated;
	}
}
