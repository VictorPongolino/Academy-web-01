package academy.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academy.models.EntidadeExistenteException;
import academy.models.PersonagensDAO;

@WebServlet("/cadastrar")
public class Cadastrar extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PersonagensDAO personagensDao = new PersonagensDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/cadastrar.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long id = Long.parseLong(req.getParameter("id")); 
		String nome = req.getParameter("nome");
		try {
			personagensDao.adicionar(id, nome);
			resp.sendRedirect("/listar");
		} catch (EntidadeExistenteException eee) {
			System.err.println(eee.getMessage());
			resp.sendRedirect("");
		}
		
	}
}
