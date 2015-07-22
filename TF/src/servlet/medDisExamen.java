package servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bjac.Cita;
import bjac.Medico;
@SuppressWarnings("serial")
public class medDisExamen extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String fecha = req.getParameter("fecha");
		String hora = req.getParameter("hora");
		List<String> h = new ArrayList<String>();
		List<String> h2 = new ArrayList<String>();
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query qcita = pm.newQuery(Cita.class);
		Query qmed = pm.newQuery(Medico.class);
		
		try{
			@SuppressWarnings("unchecked")
			List<Medico> meds = (List<Medico>)qmed.execute();
			qcita.setFilter("(fecha == '"+fecha+"')&&(hora == '"+hora+"')");
			@SuppressWarnings("unchecked")
			List<Cita> citas = (List<Cita>)qcita.execute();
			int temp=0;
			for(Medico m:meds){
				for(Cita c:citas){
					if(m.getDni().equals(c.getDniDoctor())){
						temp=1;
					}
				}
				if(temp==0){
					h.add(m.getNombre()+" "+m.getApellido()+" ("+m.getEspecialidad()+")");
					h2.add(m.getDni());
				}
				temp=0;
			}
			req.setAttribute("fecha", fecha);
			req.setAttribute("hora", hora);
			req.setAttribute("medicosDisponibles", h);
			req.setAttribute("dnis", h2);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/medDisExamen.jsp");
			rd.forward(req, resp);
		}catch(Exception e){
			
		}finally{
			 qcita.closeAll();
			 qmed.closeAll();
		}
		
	}
}