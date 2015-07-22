package servlet;

import java.io.IOException;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bjac.*;

@SuppressWarnings("serial")
public class listaReceta extends HttpServlet{
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Receta.class);
		List<Receta> pacientes = (List<Receta>) q.execute();
		req.setAttribute("pacientes", pacientes);
		for(Receta f:pacientes){
			System.out.println(f);
		}
		
	}
}