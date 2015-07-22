package servlet;
import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import bjac.GenerarExamen;
@SuppressWarnings("serial")
public class guardarGeneradorExamen extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String id = req.getParameter("id");
		String dnieMedico = req.getParameter("dnim");
		String dniPaciente = req.getParameter("dnip");
		String fecha = req.getParameter("fecha");
		String hora = req.getParameter("hora");
		String descripsion = req.getParameter("desc");
		String medicoExamen = req.getParameter("dniMedExamen");
		
		GenerarExamen p = new GenerarExamen(id,dniPaciente,dnieMedico,medicoExamen,descripsion,fecha,hora);
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(p);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/indexMedico.jsp");
			rd.forward(req, resp);
		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrió un error, <a href='index.jsp'>vuelva a intentarlo</a>");
		}finally{
			pm.close();
		}
	}
}