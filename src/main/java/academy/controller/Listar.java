package academy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academy.models.PersonagensDAO;

@WebServlet("/listar")
public class Listar extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PersonagensDAO personagensDao = new PersonagensDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("personagens", personagensDao.getTodos());
		RequestDispatcher rd = req.getRequestDispatcher("/listar.jsp");
		rd.forward(req, resp);
	}
}
