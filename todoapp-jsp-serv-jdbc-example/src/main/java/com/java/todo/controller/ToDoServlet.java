package com.java.todo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.java.todo.dao.ToDoDao;
import com.java.todo.model.BasicDetails;

@WebServlet("/")
public class ToDoServlet extends HttpServlet {
	private ToDoDao tdd;
    public void init() throws ServletException {
    	tdd = new ToDoDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getServletPath();
		System.out.println("hello action : "+action);
		try
		{
			switch(action)
			{
				case "/showRegister":
			        request.getRequestDispatcher("/todoregister.jsp").forward(request, response);
			        break;
				case "/showloginValidate":
					request.getRequestDispatcher("/todologinpage.jsp").forward(request, response);
					break;
				case "/register":
					insertnewuser(request,response);
					break;
				case "/loginValidate":
					vailduser(request,response);
					break;
					
				default:
					request.getRequestDispatcher("/todologinpage.jsp").forward(request, response);
					break;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void vailduser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username: "+username);
		System.out.println("password: "+password);
		BasicDetails bd = new BasicDetails(username,password);
		boolean found = tdd.validate(username, password);
		if(found == true)
		{
			 response.sendRedirect(request.getContextPath() + "/TodoListServlet/list");
		}
		else
		{
			request.setAttribute("errorMsg", "Invalid username and password! Please Sign up");
            request.getRequestDispatcher("/todologinpage.jsp").forward(request, response);
		}
	}

	private void insertnewuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("firstname: "+firstname);
		System.out.println("lastname: "+lastname);
		System.out.println("username: "+username);
		System.out.println("password: "+password);
		BasicDetails bd = new BasicDetails(firstname,lastname,username,password); 
		int res = tdd.insertData(bd);
		if(res == 1)
		{
			request.setAttribute("notification", "User Resgister Successfully");			
		}
		request.getRequestDispatcher("/todoregister.jsp").forward(request, response);
	}
}
