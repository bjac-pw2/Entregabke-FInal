package servlet;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bjac.*;

@SuppressWarnings("serial")
public class listaUsuarios extends HttpServlet{
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Usuario.class);
		List<Usuario> usuarios= (List<Usuario>) q.execute();
		req.setAttribute("usuarios", usuarios);
		RequestDispatcher rd = req.getRequestDispatcher("cJAdmin?option=12");
		rd.forward(req, resp);
	}
}