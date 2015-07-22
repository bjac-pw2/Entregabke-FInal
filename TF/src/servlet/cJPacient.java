package servlet;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import bjac.Cita;
import bjac.GenerarExamen;
import bjac.Receta;
@SuppressWarnings("serial")
public class cJPacient extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			String option=req.getParameter("option");
			if(option.equals("1")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/indexPaciente.jsp");
				rd.forward(req, resp);
			}
			
			if(option.equals("18")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/modPassword.jsp");
				rd.forward(req, resp);
			}
			if(option.equals("21")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/reservarCita.jsp");
				rd.forward(req, resp);
			}
			if(option.equals("2")){
				HttpSession sesion= req.getSession();
				String paciente=""+sesion.getAttribute("usuario");
				PersistenceManager pm = PMF.get().getPersistenceManager();
				Query q = pm.newQuery(Cita.class);
				try{
					q.setFilter("(dniPaciente == '"+paciente+"')");
					@SuppressWarnings("unchecked")
					List<Cita> citas = (List<Cita>)q.execute();
					req.setAttribute("citas", citas);
				}catch(Exception e){
					System.out.println(e);
				}finally{
					 q.closeAll();
				}
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/historial.jsp");
				rd.forward(req, resp);
			}
			if(option.equals("3")){
				PersistenceManager pm = PMF.get().getPersistenceManager();
				Query q = pm.newQuery(Receta.class);
				try{
					q.setFilter("(keyCita == '"+req.getParameter("keyCita")+"')");
					@SuppressWarnings("unchecked")
					List<Receta> citas = (List<Receta>)q.execute();
					req.setAttribute("citas", citas);
				}catch(Exception e){
					System.out.println(e);
				}finally{
					 q.closeAll();
				}
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/verReceta.jsp");
				rd.forward(req, resp);
			}
			if(option.equals("4")){
				PersistenceManager pm = PMF.get().getPersistenceManager();
				Query q = pm.newQuery(GenerarExamen.class);
				try{
					q.setFilter("(keyCita == '"+req.getParameter("keyCita")+"')");
					@SuppressWarnings("unchecked")
					List<GenerarExamen> citas = (List<GenerarExamen>)q.execute();
					req.setAttribute("citas", citas);
				}catch(Exception e){
					System.out.println(e);
				}finally{
					 q.closeAll();
				}
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/verGenerarExamen.jsp");
				rd.forward(req, resp);
			}
		}catch (ServletException e) {
			System.out.println(e.getMessage());
		}
	}

}