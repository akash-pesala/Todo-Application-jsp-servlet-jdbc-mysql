package com.java.todo.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.todo.dao.TodocreateDaoImp;
import com.java.todo.model.TodoDetails;

@WebServlet("/TodoListServlet/*")
public class TodoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TodocreateDaoImp tdci;
	
    public void init() throws ServletException {
    	tdci = new TodocreateDaoImp();
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	doGet(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getPathInfo();

		System.out.println("action in todo: "+action);
		try
		{
			switch(action)
			{
				case "/list":
					listTodo(request,response);
					break;
				case "/new":
					newTodo(request,response);
					break;
				case "/insert":
					insertTodo(request,response);
					break;
				case "/edit":
					editTodo(request,response);
					break;
				case "/update":
					updateTodo(request,response);
					break;
				case "/delete":
					deleteTodo(request,response);
					break;
				default:
					listTodo(request,response);
					break;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void newTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/todo-form.jsp").forward(request, response);		
	}

	private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean found = tdci.deletetodo(id);
		if(found)
		{
			response.sendRedirect("list");
		}
	}

	private void updateTodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		LocalDate targetDate = LocalDate.parse(request.getParameter("date")); 
		boolean status = Boolean.valueOf(request.getParameter("status"));
		TodoDetails td = new TodoDetails(id,title, description, targetDate, status);
		boolean updated = tdci.updatetodo(td);
		if (updated) {
	        response.sendRedirect("list");
	    }
		
	}

	private void editTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		TodoDetails exittd = tdci.selecttodo(id);
		request.setAttribute("td", exittd);
		request.getRequestDispatcher("/todo-form.jsp").forward(request, response);
	}

	private void listTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TodoDetails> listtodo = tdci.selectAll();
		request.setAttribute("listingtodo", listtodo);
		request.getRequestDispatcher("/todo-list.jsp").forward(request, response);
	}

	private void insertTodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		LocalDate targetDate = LocalDate.parse(request.getParameter("date")); 
		boolean status = Boolean.valueOf(request.getParameter("status"));
		TodoDetails td = new TodoDetails(title, description, targetDate, status);
		tdci.inserttodo(td);
		response.sendRedirect("list");
	}


}
