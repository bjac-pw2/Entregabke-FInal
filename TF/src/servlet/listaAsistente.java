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
public class listaAsistente extends HttpServlet{
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Asistente.class);
		List<Asistente> asistentes = (List<Asistente>) q.execute();
		req.setAttribute("asistentes", asistentes);
		RequestDispatcher rd = req.getRequestDispatcher("cJAdmin?option=10");
		rd.forward(req, resp);
		
	}
}