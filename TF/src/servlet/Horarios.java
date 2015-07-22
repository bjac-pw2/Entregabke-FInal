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
import javax.servlet.http.HttpSession;

import bjac.Cita;
@SuppressWarnings("serial")
public class Horarios extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String fecha = req.getParameter("fecha");
		HttpSession sesion= req.getSession();
		String medico=""+sesion.getAttribute("usuario");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		resp.setContentType("text/html");
		Query q = pm.newQuery(Cita.class);
		try{
			q.setFilter("(fecha == '"+fecha+"')&&(dniMedico == '"+medico+"')");
			@SuppressWarnings("unchecked")
			List<Cita> citas = (List<Cita>)q.execute(fecha);
			req.setAttribute("citas", citas);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/horarioMedico.jsp");
			rd.forward(req, resp);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			 q.closeAll();
		}
		
	}
}